package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

import kotlin.jvm.functions.Function1;

public class PublicLambdaFunction {

    public static Integer main(String[] args) {
        ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

        Function1<Integer, Integer> lambdaFunction = classWithPublicFunctions.getLambdaFunction();

        return lambdaFunction.invoke(3);
    }
}
