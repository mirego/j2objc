package com.google.devtools.j2objc.util;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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


class KotlinTestList implements List {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NotNull Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public void add(int i, Object o) {

    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @NotNull
    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection collection) {
        return false;
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] objects) {
        return new Object[0];
    }
}