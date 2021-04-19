package com.google.devtools.j2objc.util;

import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.MethodInvocation;
import com.google.devtools.j2objc.ast.TreeUtil;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import kotlin.Metadata;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.jvm.KotlinClassHeader;
import kotlinx.metadata.jvm.KotlinClassMetadata;

public final class KotlinUtil {

    public enum KotlinCollectionType {
        LIST,
        NONE,
    }

    public static KotlinCollectionType getKotlinReturnType(TypeMirror type) {
        TypeElement typeElement = TypeUtil.asTypeElement(type);
        if (typeElement != null) {
            if (typeElement.getQualifiedName().contentEquals("java.util.List")) {
                return KotlinCollectionType.LIST;
            }
        }

        return KotlinCollectionType.NONE;
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

    public static KotlinCollectionType getExpressionKotlinReturnType(Expression expression) {
        if (expression instanceof MethodInvocation) {
            MethodInvocation methodInvocation = (MethodInvocation) expression;
            return getKotlinReturnType(methodInvocation.getExecutablePair().element().getReturnType());
        }

        return KotlinCollectionType.NONE;
    }
}
