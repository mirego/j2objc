package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithEscapedStringProperty;

public class EscapedStringProperty {

    public static String main(String[] args) {

        ClassWithEscapedStringProperty classWithEscapedStringProperty = new ClassWithEscapedStringProperty("testString\n");

        return classWithEscapedStringProperty.getEscapedString();
    }
}
