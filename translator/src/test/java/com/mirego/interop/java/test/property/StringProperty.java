package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithStringProperty;

public class StringProperty {

    public static String main(String[] args) {

        ClassWithStringProperty classWithStringProperty = new ClassWithStringProperty("testString");

        return classWithStringProperty.getStringProperty();
    }
}
