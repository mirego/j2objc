package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicFunctionReturningCharacter {

    public static Character main(String[] args) {

        ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

        return classWithPublicFunctions.returnCharacter();
    }
}
