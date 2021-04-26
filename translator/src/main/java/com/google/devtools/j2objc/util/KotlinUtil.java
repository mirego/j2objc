package com.google.devtools.j2objc.util;

import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.FieldAccess;
import com.google.devtools.j2objc.ast.FunctionInvocation;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.TreeUtil;
import com.google.devtools.j2objc.types.GeneratedTypeElement;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import kotlin.Metadata;
import kotlinx.metadata.Flag;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.jvm.KotlinClassHeader;
import kotlinx.metadata.jvm.KotlinClassMetadata;

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

    public static KmClass getKotlinMetaData(Element element) {
        Metadata meta = element.getEnclosingElement().getAnnotation(Metadata.class);
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
        return element != null && ElementUtil.isKotlinType(element);
    }

    public static KotlinWrappedTypes getExpressionKotlinReturnType(Expression expression) {
        if (expression instanceof MethodInvocation) {
            MethodInvocation methodInvocation = (MethodInvocation) expression;
            return getKotlinType(methodInvocation.getExecutablePair().element().getReturnType());
        }

        return KotlinWrappedTypes.NONE;
    }

    public static String getKotlinElementName(ExecutableElement element, NameTable nameTable) {
        String elementName =  nameTable.getFullFunctionName(element);
        return elementName.substring(0, elementName.indexOf("_"));
    }

    public static GeneratedTypeElement getKotlinArrayTypeElement() {
        return GeneratedTypeElement.newIosClass("CommonKotlinArray", null, null);
    }

    public static GeneratedTypeElement getKotlinIteratorTypeElement() {
        return GeneratedTypeElement.newIosType("CommonKotlinIterator", ElementKind.INTERFACE, null, null);
    }

    public static boolean isKotlinEnum(Element element) {
        KmClass kotlinMetaData = getKotlinMetaData(element);
        int flags = kotlinMetaData.getFlags();
        return Flag.Class.IS_ENUM_CLASS.invoke(flags);
    }
}
