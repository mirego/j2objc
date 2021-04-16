package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructor;

public class DefaultConstructor {

    public static ClassWithDefaultConstructor main(String[] args) {

        ClassWithDefaultConstructor defaultConstructor = new ClassWithDefaultConstructor("ClassWithDefaultConstructor");

        return defaultConstructor;
    }
}
