package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithoutConstructor;

public class WithoutConstructor {

    public static ClassWithoutConstructor main(String[] args) {

        ClassWithoutConstructor withoutConstructor = new ClassWithoutConstructor();

        return withoutConstructor;
    }
}
