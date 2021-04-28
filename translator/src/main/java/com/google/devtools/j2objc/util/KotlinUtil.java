package com.google.devtools.j2objc.util;

import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.TreeUtil;

import javax.annotation.Nullable;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import kotlin.Metadata;
import kotlinx.metadata.Flag;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmProperty;
import kotlinx.metadata.jvm.KotlinClassHeader;
import kotlinx.metadata.jvm.KotlinClassMetadata;

import java.util.List;

public final class KotlinUtil {

    private KotlinUtil() {
        // DISABLED
    }

    public enum KotlinWrappedTypes {
        NONE,
        ARRAY,
        LIST,
    }

    public static KotlinWrappedTypes getKotlinType(TypeMirror type) {
        if (TypeUtil.isArray(type)) {
            return KotlinWrappedTypes.ARRAY;
        }
        TypeElement typeElement = TypeUtil.asTypeElement(type);
        if (typeElement != null) {
            if (typeElement.getQualifiedName().contentEquals("java.util.List")) {
                return KotlinWrappedTypes.LIST;
            }
        }

        return KotlinWrappedTypes.NONE;
    }

    public static KmClass getExecutableElementKotlinMetaData(Element element) {
        return getElementKotlinMetaData(element.getEnclosingElement());
    }

    public static KmClass getElementKotlinMetaData(Element element) {
        Metadata meta = element.getAnnotation(Metadata.class);
        KotlinClassHeader header = new KotlinClassHeader(meta.k(), meta.mv(), meta.bv(), meta.d1(), meta.d2(), meta.xs(), meta.pn(), meta.xi());
        KotlinClassMetadata metadata = KotlinClassMetadata.read(header);
        return ((KotlinClassMetadata.Class) metadata).toKmClass();
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
        KmClass kotlinMetaData = getExecutableElementKotlinMetaData(element);
        return isKotlinEnum(kotlinMetaData);
    }

    public static boolean isKotlinEnum(KmClass kotlinMetaData) {
        return isEnumKmClass(kotlinMetaData);
    }

    public static boolean isKotlinCompanionObjectOrObject(ExecutableElement element) {
        KmClass kotlinMetaData = getExecutableElementKotlinMetaData(element);
        return isKotlinCompanionObjectOrObject(kotlinMetaData);
    }

    public static boolean isElementKotlinCompanionObjectOrObject(Element element) {
        KmClass kotlinMetaData = getElementKotlinMetaData(element);
        return isKotlinCompanionObjectOrObject(kotlinMetaData);
    }

    public static boolean isKotlinCompanionObjectOrObject(KmClass kotlinMetaData) {
        return isCompanionObjectKmClass(kotlinMetaData) || isObjectKmClass(kotlinMetaData);
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
        for (Element elem : node.getEnclosedElements()) {
            if(isKotlinType(elem)) {
                return true;
            }
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
    public static KmFunction matchFunctionNameWithKotlin(ExecutableElement node, KmClass kotlinClass) {
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
    public static KmProperty getKotlinPropertyAccessor(ExecutableElement node, KmClass kotlinClass) {
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
}
