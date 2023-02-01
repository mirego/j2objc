package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithByteProperty;

public class ByteProperty {

    public static byte main(String[] args) {

        ClassWithByteProperty classWithByteProperty = new ClassWithByteProperty((byte) 1);

        return classWithByteProperty.getByteProperty();
    }
}
