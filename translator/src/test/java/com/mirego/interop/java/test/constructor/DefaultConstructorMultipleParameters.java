package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorMultipleParameters;

public class DefaultConstructorMultipleParameters {

    public static ClassWithDefaultConstructorMultipleParameters main(String[] args) {

        ClassWithDefaultConstructorMultipleParameters defaultConstructorMultipleParameters = new ClassWithDefaultConstructorMultipleParameters("First", "Second");

        return defaultConstructorMultipleParameters;
    }
}
