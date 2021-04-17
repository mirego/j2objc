package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicInnerClassFunction {

    public static Integer main(String[] args) {

        ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

        return classWithPublicFunctions.innerClassFunction(1, 2);
    }
}
