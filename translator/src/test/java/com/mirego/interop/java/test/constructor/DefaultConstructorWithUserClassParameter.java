package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithUserClassParameter;
import com.mirego.interop.kotlin.test.constructor.ClassWithoutConstructor;

public class DefaultConstructorWithUserClassParameter {

    public static ClassWithDefaultConstructorWithUserClassParameter main(String[] args) {

        ClassWithDefaultConstructorWithUserClassParameter defaultConstructorWithUserClassParameter = new ClassWithDefaultConstructorWithUserClassParameter(new ClassWithoutConstructor());

        return defaultConstructorWithUserClassParameter;
    }
}
