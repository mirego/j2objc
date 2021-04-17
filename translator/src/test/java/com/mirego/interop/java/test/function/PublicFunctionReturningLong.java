package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicFunctionReturningLong {

    public static Long main(String[] args) {

        ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

        return classWithPublicFunctions.returnLong();
    }
}
