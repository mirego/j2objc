package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicVariableArgumentsFunction {

    public static Integer main(String[] args) {

        ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

        return classWithPublicFunctions.variableArgumentsSum(1, 2, 3, 4);
    }
}
