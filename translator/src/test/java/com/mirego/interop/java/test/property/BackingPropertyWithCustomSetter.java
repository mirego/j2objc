package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithBackingPropertyCustomSetter;

public class BackingPropertyWithCustomSetter {

    public static String main(String[] args) {

        ClassWithBackingPropertyCustomSetter classWithBackingPropertyCustomSetter = new ClassWithBackingPropertyCustomSetter();
        classWithBackingPropertyCustomSetter.setBackedProperty("backed property");

        return classWithBackingPropertyCustomSetter.getBackedProperty();
    }
}
