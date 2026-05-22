// kotlin interop >>

package com.google.devtools.j2objc.util;

import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FieldAccess;
import com.google.devtools.j2objc.ast.TreeUtil;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nullable;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractTypeVisitor9;

import kotlin.Metadata;
import kotlin.metadata.Attributes;
import kotlin.metadata.ClassKind;
import kotlin.metadata.KmClass;
import kotlin.metadata.KmDeclarationContainer;
import kotlin.metadata.KmFunction;
import kotlin.metadata.KmPackage;
import kotlin.metadata.KmProperty;
import kotlin.metadata.Visibility;
import kotlin.metadata.jvm.JvmExtensionsKt;
import kotlin.metadata.jvm.KotlinClassHeader;
import kotlin.metadata.jvm.KotlinClassMetadata;

public final class KotlinUtil {

  private KotlinUtil() {
    // DISABLED
  }

  public static boolean isExtensionFunction(KmFunction loopFunction) {
    return loopFunction.getReceiverParameterType() != null;
  }

  public enum KotlinWrappedTypes {
    NONE,
    ARRAY,
    ARRAY_BOOLEAN,
    ARRAY_BYTE,
    ARRAY_CHAR,
    ARRAY_DOUBLE,
    ARRAY_FLOAT,
    ARRAY_INT,
    ARRAY_LONG,
    ARRAY_SHORT,
    LIST,
  }

  private static final String JAVA_UTIL_LIST = "java.util.List";
  private static final String KOTLIN_JVM_INSTANCE_IDENTIFIER = "INSTANCE";

  private static final List<String> ENUM_SPECIAL_STATIC_METHODS = List.of(
    "values",
    "valueOf"
  );

  public static KotlinWrappedTypes getKotlinWrappedType(TypeMirror type) {
    if (TypeUtil.isArray(type)) {
      TypeKind typeKind = type.accept(new TypeKindTypeVisitor() {
        @Override
        public TypeKind visitArray(ArrayType t, Void unused) {
          return t.getComponentType().getKind();
        }
      }, null);
      switch (typeKind) {
          case BOOLEAN:
              return KotlinWrappedTypes.ARRAY_BOOLEAN;
          case BYTE:
              return KotlinWrappedTypes.ARRAY_BYTE;
          case SHORT:
              return KotlinWrappedTypes.ARRAY_SHORT;
          case INT:
              return KotlinWrappedTypes.ARRAY_INT;
          case LONG:
              return KotlinWrappedTypes.ARRAY_LONG;
          case CHAR:
              return KotlinWrappedTypes.ARRAY_CHAR;
          case FLOAT:
              return KotlinWrappedTypes.ARRAY_FLOAT;
          case DOUBLE:
              return KotlinWrappedTypes.ARRAY_DOUBLE;
          default:
              return KotlinWrappedTypes.ARRAY;
      }
    }

    TypeElement typeElement = TypeUtil.asTypeElement(type);
    if (typeElement != null) {
      if (typeElement.getQualifiedName().contentEquals(JAVA_UTIL_LIST)) {
        return KotlinWrappedTypes.LIST;
      }
    }

    return KotlinWrappedTypes.NONE;
  }

  @Nullable
  public static KmDeclarationContainer getElementKotlinDeclarationContainer(Element element) {
    Element classElement;
    if (element.getKind() == ElementKind.CLASS
        || element.getKind() == ElementKind.INTERFACE
        || element.getKind() == ElementKind.ENUM) {
      classElement = element;
    } else {
      classElement = element.getEnclosingElement();
    }

    KmDeclarationContainer declarationContainer = tryGetKotlinClassMetaData(classElement);
    if (declarationContainer != null) {
      return declarationContainer;
    }

    return tryGetKotlinPackageMetaData(classElement);
  }

  @Nullable
  public static KmClass getExecutableElementKotlinClassMetaData(Element element) {
    return getElementKotlinClassMetaData(element.getEnclosingElement());
  }

  @Nullable
  public static KmClass getElementKotlinClassMetaData(Element element) {
    KotlinClassMetadata metadata = tryGetElementMetaData(element);
    if (metadata == null) {
      return null;
    }

    if (metadata instanceof KotlinClassMetadata.Class) {
      return ((KotlinClassMetadata.Class) metadata).getKmClass();
    }

    return null;
  }

  public static KmClass tryGetKotlinClassMetaData(Element element) {
    KotlinClassMetadata metadata = tryGetElementMetaData(element);
    if (metadata instanceof KotlinClassMetadata.Class) {
      return ((KotlinClassMetadata.Class) metadata).getKmClass();
    }

    return null;
  }

  public static KmPackage tryGetKotlinPackageMetaData(Element element) {
    KotlinClassMetadata metadata = tryGetElementMetaData(element);
    if (metadata instanceof KotlinClassMetadata.FileFacade) {
      return ((KotlinClassMetadata.FileFacade) metadata).getKmPackage();
    }

    return null;
  }

  public static KotlinClassMetadata tryGetElementMetaData(Element element) {
    Metadata meta = element.getAnnotation(Metadata.class);
    if (meta == null) {
      return null;
    }

    KotlinClassHeader header = new KotlinClassHeader(meta.k(), meta.mv(), meta.d1(), meta.d2(), meta.xs(), meta.pn(), meta.xi());
    return KotlinClassMetadata.readStrict(header);
  }

  public static Element getElementFromExpression(Expression expression) {
    if (expression == null) {
      return null;
    }

    Element element = TreeUtil.getVariableElement(expression);
    if (element == null) {
      element = TreeUtil.getExecutableElement(expression);
    }

    return element;
  }

  public static boolean isKotlinExpression(Expression expression) {
    Element element = getElementFromExpression(expression);
    return element != null && KotlinUtil.isKotlinType(element);
  }

  public static String getKotlinElementName(ExecutableElement element, NameTable nameTable) {
    String elementName = nameTable.getFullFunctionName(element);
    return elementName.substring(0, elementName.indexOf("_"));
  }

  public static boolean isKotlinEnum(KmDeclarationContainer kotlinMetaData) {
    if (!(kotlinMetaData instanceof KmClass)) {
      return false;
    }
    return isEnumKmClass((KmClass) kotlinMetaData);
  }

  public static boolean isKotlinEnumSpecialMethodCall(Element element) {
    return element.getKind() == ElementKind.METHOD &&
        isKotlinEnum(getElementKotlinClassMetaData(element.getEnclosingElement())) &&
        ENUM_SPECIAL_STATIC_METHODS.contains(element.getSimpleName().toString());
  }

  public static boolean isElementKotlinCompanionObjectOrObject(Element element) {
    KmClass kotlinMetaData = getElementKotlinClassMetaData(element);
    return isKotlinCompanionObjectOrObject(kotlinMetaData);
  }

  public static boolean isKotlinCompanionObjectOrObject(KmDeclarationContainer kotlinMetaData) {
    if (!(kotlinMetaData instanceof KmClass)) {
      return false;
    }
    return isCompanionObjectKmClass((KmClass) kotlinMetaData) || isObjectKmClass((KmClass) kotlinMetaData);
  }

  public static boolean isKotlinObjectWithoutJvmStaticAnnotation(Expression expression) {
    if (expression instanceof FieldAccess) {
      FieldAccess fieldAccess = (FieldAccess) expression;
      return fieldAccess.getName().getIdentifier().equals(KOTLIN_JVM_INSTANCE_IDENTIFIER);
    }

    return false;
  }

  private static boolean isEnumKmClass(KmClass kotlinMetaData) {
    return Attributes.getKind(kotlinMetaData) == ClassKind.ENUM_CLASS;
  }

  private static boolean isCompanionObjectKmClass(KmClass kotlinMetaData) {
    return Attributes.getKind(kotlinMetaData) == ClassKind.COMPANION_OBJECT;
  }

  private static boolean isObjectKmClass(KmClass kotlinMetaData) {
    return Attributes.getKind(kotlinMetaData) == ClassKind.OBJECT;
  }

  /**
   * Determines if an element is a Kotlin type by looking at the source file embedded in the class file.
   */
  public static boolean isKotlinType(Element node) {
    TypeElement decClass = ElementUtil.getDeclaringClass(node);

    // Fallback to use the node as the declaring type
    if (decClass == null && node instanceof TypeElement) {
      decClass = (TypeElement) node;
    }

    if (decClass == null) {
      return false;
    }

    return isKotlinClass(decClass);
  }

  public static boolean isKotlinClass(TypeElement typeElement) {
    for (AnnotationMirror mirror : typeElement.getAnnotationMirrors()) {
      TypeElement annotationElement = (TypeElement) mirror.getAnnotationType().asElement();
      if (annotationElement.getQualifiedName().contentEquals("kotlin.Metadata")) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines if a TypeElement is a Kotlin type by checking each of its enclosed elements.
   */
  public static boolean isKotlinType(TypeElement node) {
    if (isKotlinType((Element) node)) {
      return true;
    }

    Element elem = node.getEnclosingElement();
    return elem != null && isKotlinType(elem);
  }

  /**
   * Determines if a TypeMirror is a Kotlin type
   */
  public static boolean isKotlinType(TypeMirror node) {
    TypeElement typeElement = TypeUtil.asTypeElement(node);
    if (typeElement != null) {
      return isKotlinType(typeElement);
    }

    return false;
  }

  public static boolean isKotlinInterface(TypeMirror node) {
    return isKotlinType(node) && TypeUtil.isInterface(node);
  }

  public static boolean isKotlinTopLevelFunction(ExecutableElement executableElement) {
    Element clazz = executableElement.getEnclosingElement();
    KotlinClassMetadata metadata = tryGetElementMetaData(clazz);

    // This is a method on a Class that is a Kotlin's file facade: it means it's a top level function
    return metadata instanceof KotlinClassMetadata.FileFacade;
  }

  static private final String GETTER_PREFIX = "get";
  static private final String SETTER_PREFIX = "set";

  public static boolean isKotlinGetter(Element node) {
    return node.getSimpleName().toString().startsWith(GETTER_PREFIX);
  }

  public static boolean isKotlinSetter(Element node) {
    return node.getSimpleName().toString().startsWith(SETTER_PREFIX);
  }

  @Nullable
  public static KmFunction matchFunctionNameWithKotlin(ExecutableElement node, KmDeclarationContainer kotlinClass) {
    String simpleName = node.getSimpleName().toString();
    return kotlinClass.getFunctions().stream()
        .filter(func -> simpleName.equals(func.getName()))
        .findFirst()
        .orElse(null);
  }

  @Nullable
  public static KmProperty matchVariableNameWithKotlin(VariableElement node, KmDeclarationContainer kotlinClass) {
    String simpleName = node.getSimpleName().toString();
    return kotlinClass.getProperties().stream()
        .filter(property -> simpleName.equals(property.getName()))
        .findFirst()
        .orElse(null);
  }

  @Nullable
  public static KmProperty getKotlinPropertyAccessor(ExecutableElement node, KmDeclarationContainer kotlinClass) {
    if (!isKotlinGetter(node) && !isKotlinSetter(node)) {
      return null;
    }

    String simpleName = node.getSimpleName().toString();
    String propertyName = NameTable.uncapitalize(simpleName.substring(3));
    List<KmProperty> properties = kotlinClass.getProperties();
    for (KmProperty property : properties) {
      Visibility visibility = Attributes.getVisibility(property);
      if (visibility == Visibility.PRIVATE) {
        continue;
      }

      if (visibility == Visibility.PUBLIC) {
        if (propertyName.equals(property.getName())) {
          return property;
        }
      }
    }

    return null;
  }

  public static String getKotlinModuleName(TypeElement element) {
    KmDeclarationContainer declarationContainer = Objects.requireNonNull(getElementKotlinDeclarationContainer(element),
        "Can query for getKotlinJsModuleName name on a Kotlin declaration Containers only: " + element);

    if (declarationContainer instanceof KmClass) {
      return JvmExtensionsKt.getModuleName((KmClass) declarationContainer);
    } else if (declarationContainer instanceof KmPackage) {
      return JvmExtensionsKt.getModuleName((KmPackage) declarationContainer);
    }

    throw new RuntimeException("Unable to extract Kotlin class module name from: " + element);
  }

  private static class TypeKindTypeVisitor extends AbstractTypeVisitor9<TypeKind, Void> {

    @Override
    public TypeKind visitIntersection(IntersectionType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitPrimitive(PrimitiveType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitNull(NullType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitArray(ArrayType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitDeclared(DeclaredType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitError(ErrorType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitTypeVariable(TypeVariable t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitWildcard(WildcardType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitExecutable(ExecutableType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitNoType(NoType t, Void p) {
      return null;
    }

    @Override
    public TypeKind visitUnion(UnionType t, Void p) {
      return null;
    }
  }
}

// kotlin interop <<
