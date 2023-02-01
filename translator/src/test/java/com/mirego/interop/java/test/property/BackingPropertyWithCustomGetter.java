package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithBackingPropertyCustomGetter;

public class BackingPropertyWithCustomGetter {

    public static String main(String[] args) {

        ClassWithBackingPropertyCustomGetter classWithBackingPropertyCustomGetter = new ClassWithBackingPropertyCustomGetter();

        return classWithBackingPropertyCustomGetter.getBackedProperty();
    }
}
