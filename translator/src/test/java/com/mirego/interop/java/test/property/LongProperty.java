package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithLongProperty;

public class LongProperty {

    public static long main(String[] args) {

        ClassWithLongProperty classWithLongProperty = new ClassWithLongProperty(1);

        return classWithLongProperty.getLongProperty();
    }
}
