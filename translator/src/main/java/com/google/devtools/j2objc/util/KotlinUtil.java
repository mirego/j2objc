package com.google.devtools.j2objc.util;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
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

    private static boolean isJavaCollectionType(TypeMirror returnType) {
        if (returnType.getKind() == TypeKind.ARRAY) {
            return true;
        }

        return false;
    }

    public static KmClass getKotlinMetaData(Element element) {
        Metadata meta = element.getEnclosingElement().getAnnotation(Metadata.class);
        KotlinClassHeader header = new KotlinClassHeader(meta.k(), meta.mv(), meta.bv(), meta.d1(), meta.d2(), meta.xs(), meta.pn(), meta.xi());
        KotlinClassMetadata metadata = KotlinClassMetadata.read(header);
        return ((KotlinClassMetadata.Class) metadata).toKmClass();
    }
}
