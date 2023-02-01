package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicStaticFunction {

    public static String main(String[] args) {

        return ClassWithPublicFunctions.Companion.staticReturnString();
    }
}
