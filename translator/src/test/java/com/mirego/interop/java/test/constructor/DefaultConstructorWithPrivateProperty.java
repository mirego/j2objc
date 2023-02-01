package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithPrivateProperty;

public class DefaultConstructorWithPrivateProperty {

    public static ClassWithDefaultConstructorWithPrivateProperty main(String[] args) {

        ClassWithDefaultConstructorWithPrivateProperty defaultConstructorWithPrivateProperty = new ClassWithDefaultConstructorWithPrivateProperty("ClassWithDefaultConstructorWithPrivateProperty");

        return defaultConstructorWithPrivateProperty;
    }
}
