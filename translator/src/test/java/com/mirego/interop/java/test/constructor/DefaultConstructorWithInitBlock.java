package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithInitBlock;

public class DefaultConstructorWithInitBlock {

    public static ClassWithDefaultConstructorWithInitBlock main(String[] args) {

        ClassWithDefaultConstructorWithInitBlock defaultConstructorWithInitBlock = new ClassWithDefaultConstructorWithInitBlock("ClassWithDefaultConstructorWithInitBlock");

        return defaultConstructorWithInitBlock;
    }
}
