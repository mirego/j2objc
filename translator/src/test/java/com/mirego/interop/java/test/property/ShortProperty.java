package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithShortProperty;

public class ShortProperty {

    public static short main(String[] args) {

        ClassWithShortProperty classWithShortProperty = new ClassWithShortProperty((short) 1);

        return classWithShortProperty.getShortProperty();
    }
}
