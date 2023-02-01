package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithBackingFieldCustomGetter;

public class BackingFieldWithCustomGetter {

    public static String main(String[] args) {

        ClassWithBackingFieldCustomGetter classWithBackingFieldCustomGetter = new ClassWithBackingFieldCustomGetter();

        return classWithBackingFieldCustomGetter.getBackedField();
    }
}
