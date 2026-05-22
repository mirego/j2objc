/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc.util;


import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.devtools.j2objc.J2ObjC;
import com.google.devtools.j2objc.Options;
import com.google.devtools.j2objc.ast.EnumConstantDeclaration;
import com.google.devtools.j2objc.ast.FunctionDeclaration;
import com.google.devtools.j2objc.ast.MethodDeclaration;
import com.google.devtools.j2objc.ast.SingleVariableDeclaration;
import com.google.devtools.j2objc.types.NativeType;
import com.google.devtools.j2objc.types.PointerType;
import com.google.j2objc.annotations.ObjectiveCAdapterMethod;
import com.google.j2objc.annotations.ObjectiveCName;
import com.google.j2objc.annotations.ObjectiveCNativeEnumName;
import com.google.j2objc.annotations.SwiftName;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.regex.Pattern;
// kotlin interop >>
import java.util.stream.Collectors;
// kotlin interop <<
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
// kotlin interop >>
import kotlin.Pair;
import kotlin.metadata.Attributes;
import kotlin.metadata.KmClass;
import kotlin.metadata.KmClassifier;
import kotlin.metadata.KmConstructor;
import kotlin.metadata.KmDeclarationContainer;
import kotlin.metadata.KmFunction;
import kotlin.metadata.KmType;
import kotlin.metadata.KmTypeParameter;
import kotlin.metadata.KmTypeProjection;
import kotlin.metadata.jvm.KotlinClassMetadata;
// kotlin interop <<
import org.jspecify.annotations.Nullable;

/**
 * Singleton service for type/method/variable name support.
 *
 * @author Tom Ball
 */
public class NameTable {

  private final TypeUtil typeUtil;
  private final ElementUtil elementUtil;
  private final CaptureInfo captureInfo;
  private final Options options;
  private final Map<VariableElement, String> variableNames = new HashMap<>();
  private final Map<ExecutableElement, String> methodSelectorCache = new HashMap<>();
  private final Map<TypeElement, String> fullNameCache = new HashMap<>();

  public static final String INIT_NAME = "init";
  public static final String RETAIN_METHOD = "retain";
  public static final String RELEASE_METHOD = "release";
  public static final String DEALLOC_METHOD = "dealloc";
  public static final String FINALIZE_METHOD = "finalize";

  // The JDT compiler requires package-info files be named as "package-info",
  // but that's an illegal type to generate.
  public static final String PACKAGE_INFO_CLASS_NAME = "package-info";
  private static final String PACKAGE_INFO_OBJC_NAME = "package_info";

  // The self name in Java is reserved in Objective-C, but functionized methods
  // actually want the first parameter to be self. This is an internal name,
  // converted to self during generation.
  public static final String SELF_NAME = "$$self$$";
  public static final String ID_TYPE = "id";

  private static final Logger logger = Logger.getLogger(NameTable.class.getName());

  private static final String RESERVED_NAMES_FILE = "reserved_names.txt";
  private static final Splitter RESERVED_NAMES_SPLITTER =
      Splitter.on(CharMatcher.whitespace()).omitEmptyStrings();

  /**
   * The list of predefined types, common primitive typedefs, constants and
   * variables. Loaded from a resource file.
   */
  private static ImmutableSet<String> reservedNames = loadReservedNames(
      () -> J2ObjC.class.getResourceAsStream(RESERVED_NAMES_FILE));

  // Regex pattern for fully-qualified Java class or package names.
  private static final String JAVA_CLASS_NAME_REGEX
      = "(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*\\.)*"
          + "\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*";
  private static final Pattern JAVA_CLASS_NAME_PATTERN = Pattern.compile(JAVA_CLASS_NAME_REGEX);


  private static ImmutableSet<String> loadReservedNames(Supplier<InputStream> inputStream) {
    try (InputStream stream = inputStream.get();
        BufferedReader lines = new BufferedReader(new InputStreamReader(stream, "UTF-8"))) {
      ImmutableSet.Builder<String> builder = ImmutableSet.builder();
      String line;
      while ((line = lines.readLine()) != null) {
        if (line.startsWith("#")) {
          continue;
        }
        builder.addAll(RESERVED_NAMES_SPLITTER.split(line));
      }
      return builder.build();
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  public static void addReservedNames(String file) {
    ImmutableSet.Builder<String> updatedReservedNames = ImmutableSet.builder();
    updatedReservedNames.addAll(reservedNames);
    updatedReservedNames.addAll(
        loadReservedNames(
            () -> {
              try {
                return new FileInputStream(file);
              } catch (FileNotFoundException e) {
                throw new AssertionError(e);
              }
            }));
    reservedNames = updatedReservedNames.build();
  }

  private static final ImmutableSet<String> badParameterNames = ImmutableSet.of(
      // Objective-C type qualifier keywords.
      "in", "out", "inout", "oneway", "bycopy", "byref");

  /**
   * List of NSObject message names.  Java methods with one of these names are
   * renamed to avoid unintentional overriding.  Message names with trailing
   * colons are not included since they can't be overridden.  For example,
   * "public boolean isEqual(Object o)" would be translated as
   * "- (BOOL)isEqualWithObject:(NSObject *)o", not NSObject's "isEqual:".
   */
  private static final ImmutableSet<String> nsObjectMessages = ImmutableSet.of(
      "alloc", "attributeKeys", "autoContentAccessingProxy", "autorelease",
      "classCode", "classDescription", "classForArchiver",
      "classForKeyedArchiver", "classFallbacksForKeyedArchiver",
      "classForPortCoder", "className", "copy", "dealloc", "description",
      "hash", "init", "initialize", "isProxy", "load", "mutableCopy", "new",
      "release", "retain", "retainCount", "scriptingProperties", "self",
      "superclass", "toManyRelationshipKeys", "toOneRelationshipKeys",
      "version");

  /**
   * Map of package names to their specified prefixes.  Multiple packages
   * can share a prefix; for example, the com.google.common packages in
   * Guava could share a "GG" (Google Guava) or simply "Guava" prefix.
   */
  private final PackagePrefixes prefixMap;

  /**
   * Map of Java / Kotlin bridged interfaces for seamless interoperability
   * between Java and Kotlin.
   *
   * E.g.:
   * java.lang.Comparable  --> kotlin.Comparable
   *
   * J2ObjC will automatically change any reference of `java.lang.Comparable`to kotlin's
   * `kotlin.Comparable`.
   */
  private final Map<String, String> bridgedJvmKotlinInterfaceMapping;
  private final ImmutableMap<String, String> classMappings;
  private final ImmutableMap<String, String> methodMappings;

  public NameTable(TypeUtil typeUtil, CaptureInfo captureInfo, Options options) {
    this.typeUtil = typeUtil;
    this.elementUtil = typeUtil.elementUtil();
    this.captureInfo = captureInfo;
    this.options = options;
    prefixMap = options.getPackagePrefixes();

    // kotlin interop >>
    bridgedJvmKotlinInterfaceMapping = new HashMap<>();
    bridgedJvmKotlinInterfaceMapping.put(Comparable.class.getCanonicalName(), "CommonKotlinComparable");

    for (Entry<String, String> mapEntry : bridgedJvmKotlinInterfaceMapping.entrySet()) {
      options.getMappings().addClass(mapEntry.getKey(), mapEntry.getValue());
    }
    // kotlin interop <<

    classMappings = options.getMappings().getClassMappings();
    methodMappings = options.getMappings().getMethodMappings();
  }

  public void setVariableName(VariableElement var, String name) {
    String previousName = variableNames.get(var);
    if (previousName != null && !previousName.equals(name)) {
      logger.fine(String.format("Changing previous rename for variable: %s. Was: %s, now: %s",
          var.toString(), previousName, name));
    }
    variableNames.put(var, name);
  }

  /**
   * Gets the variable name without any qualifying class name or other prefix
   * or suffix attached.
   */
  public String getVariableBaseName(VariableElement var) {
    return getVarBaseName(var, ElementUtil.isGlobalVar(var));
  }

  /**
   * Gets the name of the accessor method for a static variable.
   */
  public String getStaticAccessorName(VariableElement var) {
    return getVarBaseName(var, false);
  }

  private String getVarBaseName(VariableElement var, boolean allowReservedName) {
    String name = variableNames.get(var);
    if (name != null) {
      return name;
    }
    name = ElementUtil.getName(var);
    if (name.equals("initialize")) {
      // Avoid conflict with class initialize function name.
      return "initialize_";
    }
    if (allowReservedName) {
      return name;
    }
    name = maybeRenameVar(var, name);
    return name.equals(SELF_NAME) ? "self" : name;
  }

  private static String maybeRenameVar(VariableElement var, String name) {
    if (isReservedName(name)) {
      name += '_';
    } else if (ElementUtil.isParameter(var) && badParameterNames.contains(name)) {
      name += "Arg";
    } else if (ElementUtil.isUnnamed(var)) {
      name = "_";
    }
    return name;
  }

  /**
   * Gets the variable or parameter name that should be used in a doc-comment.
   * This may be wrong if a variable is renamed by a translation phase, but will
   * handle all the reserved and bad parameter renamings correctly.
   */
  public static String getDocCommentVariableName(VariableElement var) {
    return maybeRenameVar(var, ElementUtil.getName(var));
  }

  /**
   * Gets the non-qualified variable name, with underscore suffix.
   */
  public String getVariableShortName(VariableElement var) {
    String baseName = getVariableBaseName(var);
    // kotlin interop >>
    Element enclosingElement = var.getEnclosingElement();
    if (enclosingElement != null) {
      TypeMirror type = enclosingElement.asType();
      if (type != null && KotlinUtil.isKotlinType(type)) {
        return baseName;
      }
    }
    // kotlin interop <<
    if (var.getKind().isField() && !ElementUtil.isGlobalVar(var)) {
      return baseName + '_';
    }
    return baseName;
  }

  /**
   * Gets the name of the variable as it is declared in ObjC, fully qualified.
   */
  public String getVariableQualifiedName(VariableElement var) {
    String shortName = getVariableShortName(var);
    if (ElementUtil.isGlobalVar(var)) {
      String className = getFullName(ElementUtil.getDeclaringClass(var));

      // kotlin interop >>
      if (KotlinUtil.isKotlinType(var)) {
        if (ElementUtil.isEnumConstant(var)) {
          // Enums names are generated in camelCase by Kotlin.
          return className + '.' + camelCaseEnumName(shortName);
        }
        if (className.endsWith("Kt")) {
          return className + '.' + shortName;
        }
        return className + ".shared." + shortName;
      }
      // kotlin interop <<

      if (ElementUtil.isEnumConstant(var)) {
        // Enums are declared in an array, so we use a macro to shorten the
        // array access expression.
        return "JreEnum(" + className + ", " + shortName + ")";
      }
      return className + '_' + shortName;
    }
    return shortName;
  }

  /**
   * Returns the name of an annotation property variable, extracted from its accessor element.
   */
  public static String getAnnotationPropertyName(ExecutableElement element) {
    return getMethodName(element);
  }

  /**
   * Capitalize the first letter of a string.
   */
  public static String capitalize(String s) {
    return s.length() > 0 ? Character.toUpperCase(s.charAt(0)) + s.substring(1) : s;
  }

  /** Lowercase the first letter of a string. */
  public static String lowercaseFirst(String s) {
    return s.length() > 0 ? Character.toLowerCase(s.charAt(0)) + s.substring(1) : s;
  }

  /**
   * Given a period-separated name, return as a camel-cased type name.  For
   * example, java.util.logging.Level is returned as JavaUtilLoggingLevel.
   */
  public static String camelCaseQualifiedName(String fqn) {
    StringBuilder sb = new StringBuilder();
    for (String part : fqn.split("\\.")) {
      sb.append(capitalize(part));
    }
    return sb.toString();
  }

  /**
   * Given a path, return as a camel-cased name. Used, for example, in header guards.
   */
  public static String camelCasePath(String fqn) {
    StringBuilder sb = new StringBuilder();
    for (String part : fqn.split(Pattern.quote(File.separator))) {
      sb.append(capitalize(part));
    }
    return sb.toString();
  }

  /**
   * Given a name, return as a camel-cased name using underscores as spaces. Used, for example, in
   * swift name for enums. If leadingCapital is true the string will begin with a capital (i.e.
   * CamelCase), otherwise it will be lowercase (i.e. camelCase).
   */
  public static String camelCaseName(String fqn, boolean leadingCapital) {
    StringBuilder sb = new StringBuilder();
    for (String part : Splitter.on('_').split(fqn)) {
      String caseName = Ascii.toLowerCase(part);
      if (!leadingCapital && sb.length() == 0) {
        sb.append(caseName);
      } else {
        sb.append(capitalize(caseName));
      }
    }
    if (isReservedName(sb.toString())) {
      sb.append("_");
    }
    return sb.toString();
  }

  private static final Pattern FAMILY_METHOD_REGEX =
      Pattern.compile("^[_]*(new|copy|alloc|init|mutableCopy).*");

  public static boolean needsObjcMethodFamilyNoneAttribute(String name) {
     return FAMILY_METHOD_REGEX.matcher(name).matches();
  }

  private String getParameterTypeKeyword(TypeMirror type) {
    int arrayDimensions = 0;
    while (TypeUtil.isArray(type)) {
      type = ((ArrayType) type).getComponentType();
      arrayDimensions++;
    }
    String name;
    if (type.getKind().isPrimitive()) {
      name = TypeUtil.getName(type);
    } else {
      // For type variables, use the first bound for the parameter keyword.
      List<? extends TypeMirror> bounds = typeUtil.getUpperBounds(type);
      TypeElement elem = bounds.isEmpty()
          ? TypeUtil.NS_OBJECT : typeUtil.getObjcClass(bounds.get(0));
      assert elem != null;
      if (arrayDimensions == 0 && elem.equals(TypeUtil.NS_OBJECT)) {
        // Special case: Non-array object types become "id".
        return ID_TYPE;
      }
      name = getFullName(elem);

      // kotlin interop >>
      name = removeKotlinModulePrefix(type, name);
      // kotlin interop <<
    }
    if (arrayDimensions > 0) {
      name += "Array";
      if (arrayDimensions > 1) {
        name += arrayDimensions;
      }
    }
    return name;
  }

  // kotlin interop >>
  private static String removeKotlinModulePrefix(TypeMirror type, String name) {
    if (KotlinUtil.isKotlinType(type) && name.startsWith("Common")) {
      name = name.substring("Common".length());
    }
    return name;
  }
  // kotlin interop <<

  private String parameterKeyword(TypeMirror type) {
    return "with" + capitalize(getParameterTypeKeyword(type));
  }

  private static final Pattern SELECTOR_VALIDATOR = Pattern.compile("\\w+|(\\w+:)+");

  public static void validateMethodSelector(String selector) {
    if (!SELECTOR_VALIDATOR.matcher(selector).matches()) {
      ErrorUtil.error("Invalid method selector: " + selector);
    }
  }

  private static String getMethodName(ExecutableElement method) {
    if (ElementUtil.isConstructor(method)) {
      TypeElement clazz = ElementUtil.getDeclaringClass(method);
      boolean needsPackagePrivateSuffix = ElementUtil.isTopLevel(clazz)
          && ElementUtil.getVisibilityModifiers(clazz).isEmpty()
          && !ElementUtil.isEnum(clazz)
          // Do not apply this change to classes in the default package
          // because it affects/breaks several translator tests.
          && !ElementUtil.getPackage(clazz).isUnnamed();
      return needsPackagePrivateSuffix ? "initPackagePrivate" : "init";
    }
    String name = ElementUtil.getName(method);
    if (isReservedName(name)) {
      name += "__";
    }
    return name;
  }

  private boolean appendParamKeyword(
      StringBuilder sb, VariableElement variable, char delim, boolean first) {
    String keyword = parameterKeyword(variable.asType());
    if (first) {
      keyword = capitalize(keyword);
    }
    sb.append(keyword).append(delim);
    return false;
  }

  // kotlin interop >>

  private Optional<String> checkEnclosedElementsForField(List<? extends Element> elements, String fieldName) {
    for (Element x : elements) {
      if (x.getSimpleName().toString().compareToIgnoreCase(fieldName) == 0) {
        return Optional.of(x.getSimpleName().toString());
      }
    }
    return Optional.empty();
  }

  // kotlin interop <<

  private String addParamNames(ExecutableElement method, String name, char delim) {
    StringBuilder sb = new StringBuilder(name);
    boolean first = true;
    TypeElement declaringClass = ElementUtil.getDeclaringClass(method);
    if (ElementUtil.isConstructor(method)) {
      for (VariableElement param : captureInfo.getImplicitPrefixParams(declaringClass)) {
        first = appendParamKeyword(sb, param, delim, first);
      }
    }

    // kotlin interop >>
    if (KotlinUtil.isKotlinType(method)) {
      return addParamNamesKotlin(method, name, delim, first, sb, declaringClass);
    }
    // kotlin interop <<

    for (VariableElement param : method.getParameters()) {
      first = appendParamKeyword(sb, param, delim, first);
    }
    if (ElementUtil.isConstructor(method)) {
      for (VariableElement param : captureInfo.getImplicitPostfixParams(declaringClass)) {
        first = appendParamKeyword(sb, param, delim, first);
      }
    }
    return sb.toString();
  }

  private static String nameWithoutFirstParam(String name, String firstParam) {

    // Change methods from `builderWithExpectedSizeWithInt` into `builderWithInt`
    if (Ascii.toLowerCase(name).contains(Ascii.toLowerCase(firstParam))
        && !name.startsWith(firstParam)) {
      return name.replaceFirst(capitalize(firstParam), "").replaceFirst("With", "");
    }

    if (name.contains("With")) {
      return name.substring(0, name.indexOf("With"));
    }

    return name;
  }

  private String addSwiftParamNames(
      List<SingleVariableDeclaration> parameters, String name, char delim) {
    if (parameters.isEmpty()) {
      return name + "()";
    }
    // get the name out of the map and
    SingleVariableDeclaration firstParam = parameters.get(0);
    String firstParamName = getVarBaseName(firstParam.getVariableElement(), true);

    StringBuilder sb = new StringBuilder(nameWithoutFirstParam(name, firstParamName)).append("(");
    for (SingleVariableDeclaration param : parameters) {
      String paramName = getVarBaseName(param.getVariableElement(), true);
      // Sometimes they don't have real arguments names so we'll use underscore
      if (paramName.contains("arg")
          || paramName.equals("value")
          || paramName.isEmpty()
          || paramName.equals(name)
          || paramName.equals(SELF_NAME)) {
        sb.append("_").append(delim);
      } else {
        sb.append(paramName).append(delim);
      }
    }
    return sb.append(")").toString();
  }

  public String getMethodSelector(ExecutableElement method) {
    String selector = methodSelectorCache.get(method);
    if (selector != null) {
      // kotlin interop >>
      if (selector.startsWith("get") && KotlinUtil.isKotlinType(method)) {
        return getMethodSelectorKotlin(method, selector);
      }
      // kotlin interop <<
      return selector;
    }
    selector = getMethodSelectorInner(method);
    methodSelectorCache.put(method, selector);
    return selector;
  }

  private String getMethodSelectorInner(ExecutableElement method) {
    String selector = ElementUtil.getSelector(method);
    if (selector != null) {
      return selector;
    }
    if (ElementUtil.isInstanceMethod(method)) {
      method = elementUtil.getOriginalMethod(method);
    }
    selector = getRenamedMethodName(method);
    return selectorForMethodName(method, selector != null ? selector : getMethodName(method));
  }

  private String getRenamedMethodName(ExecutableElement method) {
    String selector = methodMappings.get(Mappings.getMethodKey(method, typeUtil));
    if (selector != null) {
      validateMethodSelector(selector);
      return selector;
    }
    selector = getMethodNameFromAnnotation(method);
    if (selector != null) {
      return selector;
    }
    return null;
  }

  public String selectorForMethodName(ExecutableElement method, String name) {
    if (name.contains(":")) {
      return name;
    }
    String selector = addParamNames(method, name, ':');
    AnnotationMirror annotation = ElementUtil.getAnnotation(method, ObjectiveCAdapterMethod.class);
    if (annotation != null) {
      // Methods with adapter methods should be renamed to make it clear they are no longer
      // the expected interface (and will be hidden in KMP).
      selector = String.format("_%s", selector);
    }
    return selector;
  }

  /**
   * Returns a "Type_method" function name for static methods, such as from
   * enum types. A combination of classname plus modified selector is
   * guaranteed to be unique within the app.
   */
  public String getFullFunctionName(ExecutableElement method) {
    return getFullName(ElementUtil.getDeclaringClass(method)) + '_' + getFunctionName(method);
  }

  /**
   * Returns the name of the allocating constructor that returns a retained
   * object. The name will take the form of "new_TypeName_ConstructorName".
   */
  public String getAllocatingConstructorName(ExecutableElement method) {
    return "new_" + getFullFunctionName(method);
  }

  /**
   * Returns the name of the allocating constructor that returns a released
   * object. The name will take the form of "create_TypeName_ConstructorName".
   */
  public String getReleasingConstructorName(ExecutableElement method) {
    return "create_" + getFullFunctionName(method);
  }

  /**
   * Returns an appropriate name to use for this method as a function. This name
   * is guaranteed to be unique within the declaring class, if no methods in the
   * class have a renaming. The returned name should be given an appropriate
   * prefix to avoid collisions with methods from other classes.
   */
  public String getFunctionName(ExecutableElement method) {
    String name = ElementUtil.getSelector(method);
    if (name == null) {
      name = getRenamedMethodName(method);
    }
    if (name != null) {
      return name.replaceAll(":", "_");
    } else {
      return addParamNames(method, getMethodName(method), '_');
    }
  }

  // kotlin interop >>
  public static String getMethodNameFromAnnotation(ExecutableElement method) {
    String objectiveCName = TranslationUtil.getObjectiveCName(method);
    if (objectiveCName != null) {
      validateMethodSelector(objectiveCName);
      return objectiveCName;
    }
    // kotlin interop <<
    return null;
  }

  public @Nullable String getSwiftMethodNameFromAnnotation(MethodDeclaration method) {
    // Check if the method has the annotation
    String annotationName = swiftNameFromAnnotation(method.getExecutableElement());
    if (annotationName != null) {
      return annotationName;
    }

    if (method.getParameters().isEmpty()) {
      return null;
    }

    // Check if the class or package has the annotation
    TypeElement clazz = ElementUtil.getDeclaringClass(method.getExecutableElement());
    if (!packageHasSwiftNameAnnotation(clazz) && !elementHasSwiftNameAnnotation(clazz)) {
      return null;
    }

    ExecutableElement element = method.getExecutableElement();

    // If the annotation is still null after checking the names then it doesn't exist
    String methodName = element.getSimpleName().toString();

    // Constructors are `<init>`
    methodName = methodName.replace("<", "").replace(">", "");

    if (methodName.contains(":")) {
      methodName = methodName.replace(":", "");
    }

    return addSwiftParamNames(method.getParameters(), methodName, ':');
  }

  public @Nullable String getSwiftClassNameFromAnnotation(TypeElement clazz, boolean getParents) {
    String annotationName = swiftNameFromAnnotation(clazz);
    if (annotationName != null) {
      return annotationName;
    }

    if (!packageHasSwiftNameAnnotation(clazz) && !elementHasSwiftNameAnnotation(clazz)) {
      return null;
    }

    if (getParents) {
    NestingKind nesting = clazz.getNestingKind();
    if (nesting == NestingKind.MEMBER) {
      Element parent = clazz.getEnclosingElement();
        if (parent instanceof TypeElement && !parent.getKind().isInterface()) {
          String parentName = getSwiftClassNameFromAnnotation((TypeElement) parent, false);
        if (parentName != null) {
            return (parentName + "." + clazz.getSimpleName()).replaceAll("$", "");
        }
      }
    }
    }

    String className = clazz.getSimpleName().toString();
    className = className.replaceAll("$", "");
    return className;
  }

  public @Nullable String getSwiftFunctionNameFromAnnotation(FunctionDeclaration function) {
    if (options.emitWrapperMethods()) {
      // When wrapper methods is enable we don't need to do this because they are already `init`
      // methods.
      return null;
    }

    String functionName = function.getName();

    ExecutableElement method = function.getExecutableElement();
    if (method == null) {
      return null;
    }

    TypeElement owner = ElementUtil.getDeclaringClass(method);
    if (owner == null) {
      return null;
    }

    if (!packageHasSwiftNameAnnotation(owner)
        && !elementHasSwiftNameAnnotation(owner)
        && !elementHasSwiftNameAnnotation(method)) {
      return null;
    }

    String className = getSwiftClassNameFromAnnotation(owner, false);
    if (className == null) {
      // There isn't nice naming so fallback to the normal ObjC class name
      className = getObjCType(owner.asType()).replace(" *", "");
    }

    if (owner.getKind() == ElementKind.ENUM) {
      className = className + "Class";
    }

    StringBuilder sb = new StringBuilder();

    String annotationName = function.getExecutableElement().getSimpleName().toString();

    // Constructors are `<init>`
    annotationName = annotationName.replace("<", "").replace(">", "");

    if (annotationName.contains(":")) {
      annotationName = annotationName.replace(":", "");
    }

    annotationName = addSwiftParamNames(function.getParameters(), annotationName, ':');
    if (!functionName.contains("_init") && annotationName != null) {
      sb.append(" NS_SWIFT_NAME(");
      sb.append(className).append(".").append(annotationName);
      sb.append(")");
    } else if (functionName.contains("new_")) {
      sb.append(" NS_SWIFT_NAME(");

      if (annotationName != null) {
        sb.append(className).append(".").append(annotationName);
      } else {
        sb.append(addSwiftParamNames(function.getParameters(), className + ".init", ':'));
      }
      sb.append(")");
    }

    return sb.toString();
  }

  public static @Nullable String swiftNameFromAnnotation(Element elelement) {
    AnnotationMirror annotation = ElementUtil.getAnnotation(elelement, SwiftName.class);
    if (annotation != null) {
      return (String) ElementUtil.getAnnotationValue(annotation, "value");
    }
    return null;
  }

  public Boolean packageHasSwiftNameAnnotation(TypeElement classType) {
    if (options.swiftNaming()) {
      return true;
    }
    PackageElement packageElement = ElementUtil.getPackage(classType);
    return ElementUtil.getAnnotation(packageElement, SwiftName.class) != null;
  }

  public Boolean elementHasSwiftNameAnnotation(Element element) {
    if (options.swiftNaming()) {
      return true;
    }
    return ElementUtil.getAnnotation(element, SwiftName.class) != null;
  }

  /**
   * Converts a Java type to an equivalent Objective-C type, returning "id" for an object type.
   */
  @SuppressWarnings("StatementSwitchToExpressionSwitch")
  public static String getPrimitiveObjCType(TypeMirror type) {
    if (TypeUtil.isVoid(type)) {
      return "void";
    }
    if (!type.getKind().isPrimitive()) {
      return "id";
    }
    if (type.getKind().isPrimitive()) {
      switch (type.getKind()) {
        case BOOLEAN:
          return "bool";
        case BYTE:
          return "int8_t";
        case SHORT:
          return "int16_t";
        case INT:
          return "int32_t";
        case LONG:
          return "int64_t";
        case CHAR:
          return "unichar"; // AKA uint16_t.
        case FLOAT:
          return "float";
        case DOUBLE:
          return "double";
        default:
          return "j" + TypeUtil.getName(type);
      }
    }
    return "id";
  }

  /**
   * Converts a primitive Java type to an equivalent Objective-C type as the most inner component in
   * an array.
   */
  @SuppressWarnings("StatementSwitchToExpressionSwitch")
  public static String getPrimitiveObjCTypeArrayComponent(TypeMirror type) {
    String typeString = "JavaLang";
    switch (type.getKind()) {
      case BOOLEAN:
        typeString += "Boolean";
        break;
      case BYTE:
        typeString += "Byte";
        break;
      case SHORT:
        typeString += "Short";
        break;
      case INT:
        typeString += "Integer";
        break;
      case LONG:
        typeString += "Long";
        break;
      case CHAR:
        typeString += "Character";
        break;
      case FLOAT:
        typeString += "Float";
        break;
      case DOUBLE:
        typeString += "Double";
        break;
      default:
        return getPrimitiveObjCType(type);
    }

    typeString += " *";
    return typeString;
  }

  /** Convert a Java type into the equivalent JNI type. */
  public String getJniType(TypeMirror type) {
    if (TypeUtil.isPrimitiveOrVoid(type)) {
      return getPrimitiveObjCType(type);
    } else if (TypeUtil.isArray(type)) {
      return "jarray";
    } else if (typeUtil.isString(type)) {
      return "jstring";
    } else if (typeUtil.isClassType(type)) {
      return "jclass";
    }
    return "jobject";
  }

  /**
   * Convert a Java type to an equivalent Objective-C type with type variables resolved to their
   * bounds.
   */
  public String getObjCType(TypeMirror type) {
    return getObjcTypeInner(type, null, false, false, null);
  }

  public String getObjCType(VariableElement var) {
    return getObjcTypeInner(
        var.asType(), ElementUtil.getTypeQualifiers(var), false, false, null);
  }

  public String getObjCTypeDeclaration(TypeMirror type) {
    return getObjcTypeInner(type, null, false, false, null);
  }

  public String getObjCTypeDeclaration(
      TypeMirror type,
      boolean enableGenerics,
      TypeElement genericUsageTypeElement) {
    return getObjcTypeInner(
        type, null, false, enableGenerics, genericUsageTypeElement);
  }

  /**
   * Given a Java class type, returns the generics that would apply to the class declaration as a
   * list of string names.
   */
  public List<String> getClassObjCGenericTypeNames(TypeMirror type) {
    TypeElement typeElement = TypeUtil.asTypeElement(type);
    if (typeElement == null || !TypeUtil.isClass(type)) {
      return new ArrayList<>();
    }
    // Java protos have the <MessageType, BuilderType> generics, but these are not useful
    // in ObjC interfacing with the Java, so filter them off.
    if (typeUtil.isProtoClass(type)) {
      return new ArrayList<>();
    }
    ArrayList<String> typeNames = new ArrayList<>();
    for (TypeParameterElement paramElement : typeElement.getTypeParameters()) {
      typeNames.add(paramElement.getSimpleName().toString());
    }
    return typeNames;
  }

  private boolean isTranslatableTypeVariable(
      TypeVariable t, TypeElement parameterUsageContextTypeElement) {
    TypeParameterElement typeParamElement = TypeUtil.asTypeParameterElement(t);
    if (typeParamElement == null) {
      return false;
    }

    Element enclosingElement = typeParamElement.getEnclosingElement();
    // Skip method type parameters.
    if (enclosingElement.getKind() != ElementKind.CLASS) {
      return false;
    }

    // If there is a usage context class is the parameter type also there?
    // This avoids cases we don't yet handle, notably inner classes using the parameters
    // of their parent class.
    if (parameterUsageContextTypeElement != null) {
      if (!TypeUtil.isClass(parameterUsageContextTypeElement.asType())) {
        return false;
      }
      if (!parameterUsageContextTypeElement.getTypeParameters().contains(typeParamElement)) {
        return false;
      }
    }

    return true;
  }

  // isArrayComponent: this flag is used to generate the primitive types if they are the most inner
  /// component in arrays.
  private String getObjcTypeInner(
      TypeMirror type,
      String qualifiers,
      boolean isArrayComponent,
      boolean enableGenerics,
      TypeElement genericUsageTypeElement) {
    String objcType;
    type = TypeUtil.unannotatedType(type);
    if (type instanceof PointerType) {
      String pointeeQualifiers = null;
      if (qualifiers != null) {
        int idx = qualifiers.indexOf('*');
        if (idx != -1) {
          pointeeQualifiers = qualifiers.substring(0, idx);
          qualifiers = qualifiers.substring(idx + 1);
        }
      }
      objcType =
          getObjcTypeInner(
              ((PointerType) type).getPointeeType(),
              pointeeQualifiers,
              false,
              enableGenerics,
              genericUsageTypeElement);
      objcType = objcType.endsWith("*") ? objcType + "*" : objcType + " *";
    } else if (TypeUtil.isPrimitiveOrVoid(type)) {
      objcType =
          isArrayComponent ? getPrimitiveObjCTypeArrayComponent(type) : getPrimitiveObjCType(type);
    } else if (type instanceof ArrayType && enableGenerics) {
      TypeMirror componentType = TypeUtil.unannotatedType(((ArrayType) type).getComponentType());
      // For arrays of primitive types we prefer the IOSPrimitiveArray.h IOSArray subclasses
      // directly instead of IOSArray with generics. The IOSArray type-specific subclasses offer
      // more useful methods for accessing the primitive types the array contains with appropriate
      // Obj-C method signatures and type encodings. For example, -[IOSBooleanArray booleanAtIndex:]
      // can't be implemented as  -[IOSArray getElementAtIndex:] due to ObjC selector signature
      // requirements.
      if (TypeUtil.isPrimitiveOrVoid(componentType)) {
        TypeElement arrayTypeElement = typeUtil.getIosArray(componentType);
        objcType = getFullName(arrayTypeElement);
        objcType += isArrayComponent ? "" : " *";
      } else {
        String innerType =
            getObjcTypeInner(
                componentType,
                qualifiers,
                true,
                enableGenerics,
                genericUsageTypeElement);
        objcType = "IOSObjectArray<" + innerType;
        objcType += componentType instanceof ArrayType ? " *>" : ">";
        objcType += isArrayComponent ? "" : " *";
      }
    } else if (enableGenerics
        && ((genericUsageTypeElement != null) && !genericUsageTypeElement.getKind().isInterface())
        && TypeUtil.isTypeVariable(type)
        && isTranslatableTypeVariable((TypeVariable) type, genericUsageTypeElement)) {
      objcType = ((TypeVariable) type).asElement().getSimpleName().toString();
    } else if (enableGenerics
        && (TypeUtil.isDeclaredType(type) || TypeUtil.isNativeType(type))
        && !TypeUtil.getTypeArguments(type).isEmpty()
        && !TypeUtil.isInterface(type)
        && !typeUtil.isProtoClass(type)
        && !typeUtil.isClassType(TypeUtil.asTypeElement(type))) {
      final String finalQualifiers = qualifiers;
      // Avoid creating generics that merely state <id,id,...>. Obj-C generics only support 'id'
      // type anyway, but in practice a type with just "id" parameters cannot be assigned to a more
      // specific type where Java would sometimes allow such conversions.
      List<String> argTypes = new ArrayList<>();
      boolean hasSpecficType = false;
      for (TypeMirror argTypeMirror : TypeUtil.getTypeArguments(type)) {
        String argType =
            getObjcTypeInner(
                argTypeMirror,
                finalQualifiers,
                false,
                enableGenerics,
                genericUsageTypeElement);
        argTypes.add(argType);
        if (!argType.equals(ID_TYPE)) {
          hasSpecficType = true;
        }
      }
      if (TypeUtil.isNativeType(type)) {
        if (hasSpecficType) {
          objcType = ((NativeType) type).getNameWithTypeArgumentNames(argTypes);
        } else {
          objcType = ((NativeType) type).getName();
        }
      } else {
        if (hasSpecficType) {
          objcType =
              String.format(
                  "%s<%s> *",
                  getFullName(typeUtil.getObjcClass(type)), String.join(", ", argTypes));
        } else {
          objcType = String.format("%s *", getFullName(typeUtil.getObjcClass(type)));
        }
      }
    } else if (TypeUtil.isNativeType(type)) {
      objcType = ((NativeType) type).getName();
    } else {
      objcType = constructObjcTypeFromBounds(type);
    }
    if (qualifiers != null) {
      qualifiers = qualifiers.trim();
      if (!qualifiers.isEmpty()) {
        objcType += " " + qualifiers;
      }
    }
    return objcType;
  }

  private String constructObjcTypeFromBounds(TypeMirror type) {
    String classType = null;
    List<String> interfaces = new ArrayList<>();
    for (TypeElement bound : typeUtil.getObjcUpperBounds(type)) {
      if (bound.getKind().isInterface()) {
        interfaces.add(getFullName(bound));
      } else {
        assert classType == null : "Cannot have multiple class bounds";
        classType = getFullName(bound);
      }
    }
    String protocols = interfaces.isEmpty() ? "" : "<" + Joiner.on(", ").join(interfaces) + ">";
    return classType == null ? ID_TYPE + protocols : classType + protocols + " *";
  }

  public String getNativeEnumName(TypeElement typeElement) {
    AnnotationMirror annotation =
        ElementUtil.getAnnotation(typeElement, ObjectiveCNativeEnumName.class);
    if (annotation != null) {
      String nativeName = (String) ElementUtil.getAnnotationValue(annotation, "value");
      if (nativeName.isEmpty()) {
        ErrorUtil.error("ObjectiveCNativeEnumName must specify a name.");
      } else {
        return nativeName;
      }
    }
    return getFullName(typeElement) + "_Enum";
  }

  public String getNativeEnumConstantName(
      TypeElement enumTypeElement, EnumConstantDeclaration constantDeclaration) {
    return getNativeEnumConstantName(enumTypeElement, constantDeclaration.getVariableElement());
  }

  public String getNativeEnumConstantName(
      TypeElement enumTypeElement, VariableElement constantVariableElement) {
    String enumBaseName = getFullName(enumTypeElement) + "_Enum";
    String constantSuffix = getVariableBaseName(constantVariableElement);
    AnnotationMirror annotation =
        ElementUtil.getAnnotation(enumTypeElement, ObjectiveCNativeEnumName.class);
    if (annotation != null) {
      enumBaseName = (String) ElementUtil.getAnnotationValue(annotation, "value");
      constantSuffix = camelCaseName(constantSuffix, true);
      return enumBaseName + constantSuffix;
    } else {
      return enumBaseName + "_" + constantSuffix;
    }
  }

  public String getNativeEnumSwiftConstantName(EnumConstantDeclaration constantDeclaration) {
    return camelCaseName(getVariableBaseName(constantDeclaration.getVariableElement()), false);
  }

  public static String getNativeOrdinalPreprocessorName(String typeName) {
    return typeName + "_ORDINAL";
  }

  /**
   * Return the full name of a type, including its package.  For outer types,
   * is the type's full name; for example, java.lang.Object's full name is
   * "JavaLangObject".  For inner classes, the full name is their outer class'
   * name plus the inner class name; for example, java.util.ArrayList.ListItr's
   * name is "JavaUtilArrayList_ListItr".
   */
  public String getFullName(TypeElement element) {
    element = typeUtil.getObjcClass(element);
    String fullName = fullNameCache.get(element);
    if (fullName == null) {
      fullName = getFullNameImpl(element);
      fullNameCache.put(element, fullName);
    }
    return fullName;
  }

  public static boolean isReservedName(String name) {
    return reservedNames.contains(name) || nsObjectMessages.contains(name);
  }

  private String getFullNameImpl(TypeElement element) {
    // Avoid package prefix renaming for package-info types, and use a valid ObjC name that doesn't
    // have a dash character.
    if (ElementUtil.isPackageInfo(element)) {
      return camelCaseQualifiedName(ElementUtil.getName(ElementUtil.getPackage(element)))
          + PACKAGE_INFO_OBJC_NAME;
    }

    // Use ObjectiveCName annotation, if it exists.
    // kotlin interop >>
    String objectiveCName = TranslationUtil.getObjectiveCName(element);
    if (objectiveCName != null) {
      return objectiveCName;
    // kotlin interop <<
    }

    TypeElement outerClass = ElementUtil.getDeclaringClass(element);
    if (outerClass != null) {
      return getFullName(outerClass) + '_' + getTypeSubName(element);
    }

    // Use mapping file entry, if it exists.
    String mappedName = classMappings.get(ElementUtil.getQualifiedName(element));
    if (mappedName != null) {
      return mappedName;
    }

    // kotlin interop >>
    // This was in the original fork we got this from, not sure why : https://github.com/dhwitz/j2objc/tree/kotlin-native
    // but we want the full prefix
    if (KotlinUtil.isKotlinType(element)) {
       return getPrefixKotlin(element) + getTypeSubName(element);
    }

    // kotlin interop <<

    // Use camel-cased package+class name.
    return getPrefix(ElementUtil.getPackage(element)) + getTypeSubName(element);
  }

  private String getTypeSubName(TypeElement element) {
    if (ElementUtil.isLambda(element)) {
      return ElementUtil.getName(element);
    } else if (ElementUtil.isLocal(element)) {
      String binaryName = elementUtil.getBinaryName(element);
      int innerClassIndex = ElementUtil.isAnonymous(element)
          ? binaryName.length() : binaryName.lastIndexOf(ElementUtil.getName(element));
      while (innerClassIndex > 0 && binaryName.charAt(innerClassIndex - 1) != '$') {
        --innerClassIndex;
      }
      return binaryName.substring(innerClassIndex);
    // kotlin interop >>
    } else if (KotlinUtil.isKotlinType(element) && hasJvmNameOverrideAnnotation(element)) {
      return getStandardKotlinFileFacadeClassName(element);
    }
    // << kotlin interop
    return ElementUtil.getName(element).replace('$', '_');
  }

  // kotlin interop >>
  private boolean hasJvmNameOverrideAnnotation(TypeElement element) {
    KotlinClassMetadata metadata = KotlinUtil.tryGetElementMetaData(element);
    if (metadata instanceof KotlinClassMetadata.FileFacade) {
      // The @JvmName annotation is not available from Java compiler (this is a Kotlin annotation).
      // However, we can detect if the current class name is named following the standard (or not)
      String expectedClassNameFromFileName = getStandardKotlinFileFacadeClassName(element);
      return !ElementUtil.getName(element).equals(expectedClassNameFromFileName);
    }

    return false;
  }

  private static String getStandardKotlinFileFacadeClassName(TypeElement element) {
    String sourceFile = ElementUtil.getSourceFile(element);
    return sourceFile.substring(0, sourceFile.length() - 3) + "Kt";
  }
  // << kotlin interop

  private String getPrefix(PackageElement packageElement) {
    return prefixMap.getPrefix(packageElement);
  }

  /** Ignores the ObjectiveCName annotation. */
  private String getDefaultObjectiveCName(TypeElement element) {
    String binaryName = elementUtil.getBinaryName(element);
    return camelCaseQualifiedName(binaryName).replace('$', '_');
  }

  public Optional<String> getNameMapping(TypeElement typeElement, String typeName) {
    final String mappingFormat = "J2OBJC_NAME_MAPPING(%s, \"%s\", \"%s\")\n";
    // No mapping is needed if the default Objective-C name was not modified.
    if (typeName.equals(getDefaultObjectiveCName(typeElement))) {
      return Optional.empty();
    }

    // Return a class mapping only if there is a explicit rename.
    // kotlin interop >>
    Boolean hasObjectiveCName = TranslationUtil.hasObjectiveCName(typeElement);
    String mappedName = classMappings.get(ElementUtil.getQualifiedName(typeElement));
    if (hasObjectiveCName || mappedName != null) {
    // kotlin interop <<
      return Optional.of(
          String.format(mappingFormat, typeName, elementUtil.getBinaryName(typeElement), typeName));
    }

    // Otherwise, there was a package rename. Because only one package mapping is needed per
    // generation unit, it is safe to generate it together with a public class.
    if (ElementUtil.isTopLevel(typeElement) && ElementUtil.isPublic(typeElement)) {
      PackageElement packageElement = ElementUtil.getPackage(typeElement);
      String packageName = packageElement.getQualifiedName().toString();
      String mappedPackageName = getPrefix(packageElement);
      return Optional.of(
          String.format(mappingFormat, typeName, packageName, mappedPackageName));
    }

    return Optional.empty();
  }

  /**
   * Verifies that a fully-qualified class name is lexically correct. This method does
   * not check whether the class actually exists, however. It also will return true for
   * valid package names, since they cannot be distinguished except by parsing context.
   */
  public static boolean isValidClassName(String className) {
    return JAVA_CLASS_NAME_PATTERN.matcher(className).matches();
  }

  // kotlin interop >>

  private boolean appendParamKeywordKotlin(StringBuilder sb, String paramName, char delim, boolean first) {
    String keyword = paramName;
    if (first) {
      keyword = capitalize(keyword);
    }
    sb.append(keyword).append(delim);
    return false;
  }

  private String addParamNamesKotlin(ExecutableElement method, String name, char delim, boolean first, StringBuilder sb, TypeElement declaringClass) {
    KmDeclarationContainer declarationContainer = KotlinUtil.getElementKotlinDeclarationContainer(method);

    String methodName = method.getSimpleName().toString();
    Multimap<String, List<Pair<String, KmType>>> potentialValueParameters = ArrayListMultimap.create();
    Multimap<String, List<KmTypeParameter>> potentialTypeParameters = ArrayListMultimap.create();
    List<Pair<String, KmType>> matchingParams = null;

    List<String> jvmArgumentTypes = method.getParameters().stream()
      .map(this::getCleanedJvmParameter)
      .collect(Collectors.toList());

    List<KmTypeParameter> classTypeParameters = new ArrayList<>();
    if (declarationContainer instanceof KmClass) {
      classTypeParameters.addAll(((KmClass) declarationContainer).getTypeParameters());
    }

    if (ElementUtil.isConstructor(method)) {
      assert declarationContainer instanceof KmClass;
      KmClass kmClass = (KmClass) declarationContainer;
      for (KmConstructor loopConstructor : kmClass.getConstructors()) {
        potentialValueParameters.put(methodName, loopConstructor.getValueParameters().stream().map(it -> new Pair<>(it.getName(), it.getType())).collect(Collectors.toList()));
        potentialTypeParameters.put(methodName, null);
      }
    } else {
      assert declarationContainer != null;
      for (KmFunction loopFunction : declarationContainer.getFunctions()) {
        String functionName = loopFunction.getName();
        if (methodName.equals(functionName)) {
          if (KotlinUtil.isExtensionFunction(loopFunction)) {
            List<Pair<String, KmType>> kmValueParametersTypes = new ArrayList<>();
            kmValueParametersTypes.add(new Pair<>("", loopFunction.getReceiverParameterType()));
            kmValueParametersTypes.addAll(loopFunction.getValueParameters().stream().map(it -> new Pair<>(it.getName(), it.getType())).collect(Collectors.toList()));
            potentialValueParameters.put(functionName, kmValueParametersTypes);
            potentialTypeParameters.put(functionName, loopFunction.getTypeParameters());
          } else {
            potentialValueParameters.put(functionName, loopFunction.getValueParameters().stream().map(it -> new Pair<>(it.getName(), it.getType())).collect(Collectors.toList()));
            potentialTypeParameters.put(functionName, loopFunction.getTypeParameters());
          }
        }
      }
    }

    Iterator<Entry<String, List<Pair<String, KmType>>>> valueParametersIterator = potentialValueParameters.entries().iterator();
    Iterator<Entry<String, List<KmTypeParameter>>> typeParametersIterator = potentialTypeParameters.entries().iterator();
    while (valueParametersIterator.hasNext() && typeParametersIterator.hasNext()) {
      Entry<String, List<Pair<String, KmType>>> methodEntry = valueParametersIterator.next();
      List<Pair<String, KmType>> valueParams = methodEntry.getValue();
      List<KmTypeParameter> typeParams = typeParametersIterator.next().getValue();
      List<String> kmArgumentTypes = valueParams.stream()
        .map(kmValueParameter -> toJavaType(kmValueParameter.component2(), classTypeParameters, typeParams))
        .collect(Collectors.toList());

      if (methodEntry.getKey().equals(methodName) && jvmArgumentTypes.equals(kmArgumentTypes)) {
        if (matchingParams != null) {
          throw new RuntimeException(String.format("Found more that one matching method %s for declaration container %s", methodName, declarationContainer));
        }
        matchingParams = valueParams;
      }
    }

    int idx = 0;
    for (VariableElement param : method.getParameters()) {

      if (first && ElementUtil.isConstructor(method)) {
        sb.append("With");
      }

      if (name.startsWith("set") && checkEnclosedElementsForField(
        declaringClass.getEnclosedElements(), name.substring(3)).isPresent()) {
        break;
      }

      String paramName = param.getSimpleName().toString();
      if (matchingParams != null) {
        paramName = matchingParams.get(idx).component1();
      }

      first = appendParamKeywordKotlin(sb, paramName, delim, first);
      idx++;
    }

    return sb.toString();
  }

  private String getCleanedJvmParameter(VariableElement element) {
    // todo gaudet there must be a way to get the list type directly instead of removing it the hard way
    String elementType = element.asType().toString();
    int startIndex = elementType.indexOf('<');
    if (startIndex > 0) {
      return elementType.substring(0, startIndex);
    }

    return element.asType().toString();

  }

  private String getMethodSelectorKotlin(ExecutableElement method, String selector) {
    Optional<String> getterName =
      checkEnclosedElementsForField(
        ElementUtil.getDeclaringClass(method).getEnclosedElements(),
        selector.substring(3));
    return getterName.orElse(selector);

  }

  private String getPrefixKotlin(TypeElement element) {
    String kotlinModuleName = KotlinUtil.getKotlinModuleName(element);
    String prefix = prefixMap.getPrefix("kotlin-module/" + kotlinModuleName);

    if (prefix == null) {
      // kotlin interop >>
      // Use "Common" prefix when not specified
      prefix = "Common";
      // kotlin interop <<
    }

    return prefix;
  }

  private static final Map<String, String> kotlinToJavaPrimitiveType = new HashMap<>();

  static {
    // java primitive types
    kotlinToJavaPrimitiveType.put("kotlin/Byte", "byte");
    kotlinToJavaPrimitiveType.put("kotlin/Short", "short");
    kotlinToJavaPrimitiveType.put("kotlin/Int", "int");
    kotlinToJavaPrimitiveType.put("kotlin/Long", "long");
    kotlinToJavaPrimitiveType.put("kotlin/Char", "char");
    kotlinToJavaPrimitiveType.put("kotlin/Float", "float");
    kotlinToJavaPrimitiveType.put("kotlin/Double", "double");
    kotlinToJavaPrimitiveType.put("kotlin/Boolean", "boolean");
  }

  private static final Map<String, String> kotlinToJavaType = new HashMap<>();

  static {
    // java non-primitive types
    kotlinToJavaType.put("kotlin/Any", "java.lang.Object");
    kotlinToJavaType.put("kotlin/Cloneable", "java.lang.Cloneable");
    kotlinToJavaType.put("kotlin/Comparable", "java.lang.Comparable");
    kotlinToJavaType.put("kotlin/Enum", "java.lang.Enum");
    kotlinToJavaType.put("kotlin/Annotation", "java.lang.Annotation");
    kotlinToJavaType.put("kotlin/Deprecated", "java.lang.Deprecated");
    kotlinToJavaType.put("kotlin/CharSequence", "java.lang.CharSequence");
    kotlinToJavaType.put("kotlin/String", "java.lang.String");
    kotlinToJavaType.put("kotlin/Number", "java.lang.Number");
    kotlinToJavaType.put("kotlin/Throwable", "java.lang.Throwable");

    // java boxed primitive types
    kotlinToJavaType.put("kotlin/Byte", "java.lang.Byte");
    kotlinToJavaType.put("kotlin/Short", "java.lang.Short");
    kotlinToJavaType.put("kotlin/Int", "java.lang.Integer");
    kotlinToJavaType.put("kotlin/Long", "java.lang.Long");
    kotlinToJavaType.put("kotlin/Char", "java.lang.Char");
    kotlinToJavaType.put("kotlin/Float", "java.lang.Float");
    kotlinToJavaType.put("kotlin/Double", "java.lang.Double");
    kotlinToJavaType.put("kotlin/Boolean", "java.lang.Boolean");

    kotlinToJavaType.put("kotlin/Array", "java.lang.Array");
    kotlinToJavaType.put("kotlin/ByteArray", "java.lang.Array<Byte>");
    kotlinToJavaType.put("kotlin/ShortArray", "java.lang.Array<Short>");
    kotlinToJavaType.put("kotlin/IntArray", "java.lang.Array<Integer>");
    kotlinToJavaType.put("kotlin/LongArray", "java.lang.Array<Long>");
    kotlinToJavaType.put("kotlin/CharArray", "java.lang.Array<Char>");
    kotlinToJavaType.put("kotlin/FloatArray", "java.lang.Array<Float>");
    kotlinToJavaType.put("kotlin/DoubleArray", "java.lang.Array<Double>");
    kotlinToJavaType.put("kotlin/BooleanArray", "java.lang.Array<Boolean>");

    // java collection types
    kotlinToJavaType.put("kotlin/collections/Iterator", "java.util.Iterator");
    kotlinToJavaType.put("kotlin/collections/MutableIterator", "java.util.Iterator");
    kotlinToJavaType.put("kotlin/collections/Iterable", "java.util.Iterable");
    kotlinToJavaType.put("kotlin/collections/MutableIterable", "java.util.Iterable");
    kotlinToJavaType.put("kotlin/collections/Collection", "java.util.Collection");
    kotlinToJavaType.put("kotlin/collections/MutableCollection", "java.util.Collection");
    kotlinToJavaType.put("kotlin/collections/Set", "java.util.Set");
    kotlinToJavaType.put("kotlin/collections/MutableSet", "java.util.Set");
    kotlinToJavaType.put("kotlin/collections/List", "java.util.List");
    kotlinToJavaType.put("kotlin/collections/MutableList", "java.util.List");
    kotlinToJavaType.put("kotlin/collections/ListIterator", "java.util.ListIterator");
    kotlinToJavaType.put("kotlin/collections/MutableListIterator", "java.util.ListIterator");
    kotlinToJavaType.put("kotlin/collections/Map", "java.util.Map");
    kotlinToJavaType.put("kotlin/collections/MutableMap", "java.util.Map");
    kotlinToJavaType.put("kotlin/collections/Map.Entry", "java.util.Map.Entry");
    kotlinToJavaType.put("kotlin/collections/MutableMap.MutableEntry", "java.util.Map.Entry");
  }

  private String toJavaType(
    KmType kmType,
    List<KmTypeParameter> kmClassTypeParameters,
    List<KmTypeParameter> kmFunctionTypeParams
  ) {
    boolean isNullable = Attributes.isNullable(kmType);

    KmClassifier classifier = kmType.getClassifier();
    String kotlinType;
    if (classifier instanceof KmClassifier.Class) {
      kotlinType = ((KmClassifier.Class) classifier).getName();
    } else if (classifier instanceof KmClassifier.TypeAlias) {
      kotlinType = ((KmClassifier.TypeAlias) classifier).getName();
    } else if (classifier instanceof KmClassifier.TypeParameter) {
      KmClassifier.TypeParameter typeParameter = (KmClassifier.TypeParameter) classifier;
      kotlinType = findParamNameInTypeParameters(typeParameter, kmClassTypeParameters, kmFunctionTypeParams);
    } else {
      throw new RuntimeException(String.format("Unsupported Kotlin KmClassifier : %s", classifier.getClass().getSimpleName()));
    }

    String javaType = null;
    if (isKotlinTypeFromName(kotlinType)) {
      if (isKotlinArrayTypeFromName(kotlinType)) {
        javaType = toJavaArrayType(kmType, kmClassTypeParameters, kmFunctionTypeParams);
      } else {
        if (!isNullable) {
          javaType = kotlinToJavaPrimitiveType.get(kotlinType);
        }
        if (javaType == null) {
          javaType = kotlinToJavaType.get(kotlinType);
        }
      }
    } else {
      javaType = kotlinType.replace('/', '.');
    }

    if (javaType == null) {
      throw new RuntimeException(String.format("Could not find mapping for kotlin type : %s", kotlinType));
    }
    return javaType;
  }

  private String toJavaArrayType(
    KmType kmType,
    List<KmTypeParameter> kmClassTypeParameters,
    List<KmTypeParameter> kmFunctionTypeParams
  ) {
    List<KmTypeProjection> arguments = kmType.getArguments();
    if (arguments.size() == 1) {
      KmType type = arguments.get(0).getType();
      String javaType = toJavaType(type, kmClassTypeParameters, kmFunctionTypeParams);
      javaType += "[]";
      return javaType;
    } else {
      throw new RuntimeException(String.format("multi dimensionnal arrays not supported : %s", arguments.size()));
    }
  }

  private String findParamNameInTypeParameters(
    KmClassifier.TypeParameter typeParameter,
    List<KmTypeParameter> kmClassTypeParameters,
    List<KmTypeParameter> kmFunctionTypeParams
  ) {
    int id = typeParameter.getId();
    if (id < kmClassTypeParameters.size()) {
      return kmClassTypeParameters.get(id).getName();
    }

    id -= kmClassTypeParameters.size();
    if (id >= kmFunctionTypeParams.size()) {
      throw new RuntimeException("could not map type id with know type parameters ....");
    }

    return kmFunctionTypeParams.get(id).getName();
  }

  private boolean isKotlinTypeFromName(String type) {
    return type.indexOf("kotlin/") == 0;
  }

  private boolean isKotlinArrayTypeFromName(String type) {
    return type.equals("kotlin/Array");
  }

  /**
   * Uncapitalize the first letter of a string.
   */
  public static String uncapitalize(String s) {
    return s.isEmpty() ? s : Character.toLowerCase(s.charAt(0)) + s.substring(1);
  }

  public static String camelCaseEnumName(String name) {
    StringBuilder sb = new StringBuilder();
    boolean firstPart = true;
    String lowerCaseName = name.toLowerCase();
    for (String part : lowerCaseName.split("_")) {
      String partToAppend = (!firstPart) ? capitalize(part) : part;
      sb.append(partToAppend);
      firstPart = false;
    }
    return sb.toString();
  }

  public Optional<String> getKotlinClassMapping(String qualifiedName) {
    return Optional.ofNullable(bridgedJvmKotlinInterfaceMapping.get(qualifiedName));
  }

  // kotlin interop <<
}
