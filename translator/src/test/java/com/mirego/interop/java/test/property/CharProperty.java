package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithCharProperty;

public class CharProperty {

    public static char main(String[] args) {

        ClassWithCharProperty classWithCharProperty = new ClassWithCharProperty('a');

        return classWithCharProperty.getCharProperty();
    }
}
