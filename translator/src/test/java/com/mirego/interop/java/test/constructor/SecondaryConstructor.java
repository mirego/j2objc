package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithSecondaryConstructor;

public class SecondaryConstructor {

    public static ClassWithSecondaryConstructor main(String[] args) {

        ClassWithSecondaryConstructor secondaryConstructor = new ClassWithSecondaryConstructor();

        return secondaryConstructor;
    }
}
