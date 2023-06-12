// kotlin interop >>

package com.google.devtools.j2objc.util;

import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FieldAccess;
import com.google.devtools.j2objc.ast.TreeUtil;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.Nullable;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractTypeVisitor9;

import kotlin.Metadata;
import kotlinx.metadata.Flag;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmClassExtensionVisitor;
import kotlinx.metadata.KmClassVisitor;
import kotlinx.metadata.KmDeclarationContainer;
import kotlinx.metadata.KmExtensionType;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmPackage;
import kotlinx.metadata.KmPackageExtensionVisitor;
import kotlinx.metadata.KmPackageVisitor;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.jvm.JvmClassExtensionVisitor;
import kotlinx.metadata.jvm.JvmPackageExtensionVisitor;
import kotlinx.metadata.jvm.KotlinClassHeader;
import kotlinx.metadata.jvm.KotlinClassMetadata;

public final class KotlinUtil {

  private KotlinUtil() {
    // DISABLED
  }

  public enum KotlinWrappedTypes {
    NONE,
    ARRAY,
    PRIMITIVE_ARRAY,
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
      Boolean isPrimitive = type.accept(new BooleanTypeVisitor() {
        @Override
        public Boolean visitArray(ArrayType t, Void unused) {
          return TypeUtil.isPrimitiveOrVoid(t.getComponentType());
        }
      }, null);
      if (isPrimitive) {
        return KotlinWrappedTypes.PRIMITIVE_ARRAY;
      } else {
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

    return ((KotlinClassMetadata.Class) metadata).toKmClass();
  }

  public static KmClass tryGetKotlinClassMetaData(Element element) {
    KotlinClassMetadata metadata = tryGetElementMetaData(element);
    if (metadata instanceof KotlinClassMetadata.Class) {
      return ((KotlinClassMetadata.Class) metadata).toKmClass();
    }

    return null;
  }

  public static KmPackage tryGetKotlinPackageMetaData(Element element) {
    KotlinClassMetadata metadata = tryGetElementMetaData(element);
    if (metadata instanceof KotlinClassMetadata.FileFacade) {
      return ((KotlinClassMetadata.FileFacade) metadata).toKmPackage();
    }

    return null;
  }

  public static KotlinClassMetadata tryGetElementMetaData(Element element) {
    Metadata meta = element.getAnnotation(Metadata.class);
    if (meta == null) {
      return null;
    }

    KotlinClassHeader header = new KotlinClassHeader(meta.k(), meta.mv(), meta.d1(), meta.d2(), meta.xs(), meta.pn(), meta.xi());
    KotlinClassMetadata metadata = KotlinClassMetadata.read(header);
    return metadata;
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

  public static boolean isKotlinEnum(ExecutableElement element) {
    KmClass kotlinMetaData = getExecutableElementKotlinClassMetaData(element);
    return isKotlinEnum(kotlinMetaData);
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

  public static boolean isKotlinCompanionObjectOrObject(ExecutableElement element) {
    KmClass kotlinMetaData = getExecutableElementKotlinClassMetaData(element);
    return isKotlinCompanionObjectOrObject(kotlinMetaData);
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
    int flags = kotlinMetaData.getFlags();
    return Flag.Class.IS_ENUM_CLASS.invoke(flags);
  }

  private static boolean isCompanionObjectKmClass(KmClass kotlinMetaData) {
    int flags = kotlinMetaData.getFlags();
    return Flag.Class.IS_COMPANION_OBJECT.invoke(flags);
  }

  private static boolean isObjectKmClass(KmClass kotlinMetaData) {
    int flags = kotlinMetaData.getFlags();
    return Flag.Class.IS_OBJECT.invoke(flags);
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

    String sourceName = ElementUtil.getSourceFile(decClass);
    if (sourceName == null) {
      return false;
    }

    return sourceName.endsWith(".kt");
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
    KmFunction matchingFunction = null;
    List<KmFunction> functions = kotlinClass.getFunctions();
    for (KmFunction function : functions) {
      if (simpleName.equals(function.getName())) {
        matchingFunction = function;
        break;
      }
    }

    return matchingFunction;
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
      int flags = property.getFlags();

      if (Flag.IS_PRIVATE.invoke(flags)) {
        continue;
      }
      if (Flag.IS_PUBLIC.invoke(flags)) {
        if (Flag.Property.HAS_GETTER.invoke(flags) ||
            Flag.Property.HAS_SETTER.invoke(flags)) {
          if (propertyName.equals(property.getName())) {
            return property;
          }
        }
      }
    }

    return null;
  }

  public static String getKotlinModuleName(TypeElement element) {
    KmDeclarationContainer declarationContainer = Objects.requireNonNull(getElementKotlinDeclarationContainer(element),
        "Can query for getKotlinJsModuleName name on a Kotlin declaration Containers only: " + element);

    AtomicReference<String> moduleName = new AtomicReference<>();

    if (declarationContainer instanceof KmClass) {
      ((KmClass) declarationContainer).accept(new KmClassVisitor() {
        @Override
        public KmClassExtensionVisitor visitExtensions(@NotNull KmExtensionType type) {
          return new JvmClassExtensionVisitor() {
            @Override
            public void visitModuleName(@NotNull String name) {
              moduleName.set(name);
              super.visitModuleName(name);
            }
          };
        }
      });
    } else if (declarationContainer instanceof KmPackage) {
      ((KmPackage) declarationContainer).accept(new KmPackageVisitor() {
        @Override
        public KmPackageExtensionVisitor visitExtensions(@NotNull KmExtensionType type) {
          return new JvmPackageExtensionVisitor() {
            @Override
            public void visitModuleName(@NotNull String name) {
              moduleName.set(name);
              super.visitModuleName(name);
            }
          };
        }
      });
    }

    return Objects.requireNonNull(moduleName.get(),
        "Unable to extract Kotlin class module name from: " + element);
  }

  private static class BooleanTypeVisitor extends AbstractTypeVisitor9<Boolean, Void> {

    @Override
    public Boolean visitIntersection(IntersectionType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitPrimitive(PrimitiveType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitNull(NullType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitArray(ArrayType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitDeclared(DeclaredType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitError(ErrorType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitTypeVariable(TypeVariable t, Void p) {
      return false;
    }

    @Override
    public Boolean visitWildcard(WildcardType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitExecutable(ExecutableType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitNoType(NoType t, Void p) {
      return false;
    }

    @Override
    public Boolean visitUnion(UnionType t, Void p) {
      return false;
    }
  }
}

// kotlin interop <<
