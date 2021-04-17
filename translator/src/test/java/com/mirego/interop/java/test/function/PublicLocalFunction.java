package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicLocalFunction {

    public static String main(String[] args) {

        ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

        return classWithPublicFunctions.localFunction();
    }
}
