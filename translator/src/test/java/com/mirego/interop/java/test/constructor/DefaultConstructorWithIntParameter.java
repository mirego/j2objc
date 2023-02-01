package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithIntParameter;

public class DefaultConstructorWithIntParameter {

    public static ClassWithDefaultConstructorWithIntParameter main(String[] args) {

        ClassWithDefaultConstructorWithIntParameter defaultConstructorWithIntParameter = new ClassWithDefaultConstructorWithIntParameter(1);

        return defaultConstructorWithIntParameter;
    }
}
