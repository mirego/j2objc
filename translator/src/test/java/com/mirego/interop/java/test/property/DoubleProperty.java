package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithDoubleProperty;

public class DoubleProperty {

    public static double main(String[] args) {

        ClassWithDoubleProperty classWithDoubleProperty = new ClassWithDoubleProperty(0.1);

        return classWithDoubleProperty.getDoubleProperty();
    }
}
