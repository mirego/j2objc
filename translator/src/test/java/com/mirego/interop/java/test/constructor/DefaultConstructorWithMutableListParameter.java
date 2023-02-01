package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithMutableListParameter;

import java.util.Collections;

public class DefaultConstructorWithMutableListParameter {

    public static ClassWithDefaultConstructorWithMutableListParameter<?> main(String[] args) {

        ClassWithDefaultConstructorWithMutableListParameter<?> defaultConstructorWithMutableListParameter =
                new ClassWithDefaultConstructorWithMutableListParameter<>(Collections.singletonList(1));

        return defaultConstructorWithMutableListParameter;
    }
}
