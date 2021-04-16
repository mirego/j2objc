package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithNullableProperty;

public class NullableProperty {

    public static String main(String[] args) {

        ClassWithNullableProperty nullablePropertyClass = new ClassWithNullableProperty(null);

        return nullablePropertyClass.getNullableProperty();
    }
}
