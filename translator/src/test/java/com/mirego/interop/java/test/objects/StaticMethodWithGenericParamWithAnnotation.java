package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethodWithGenericParamWithAnnotation {

    public static String main(String[] args) {
        String testString = "stringGeneric";
        return ObjectWithMethod.staticMethodWithGenericParam(testString);
    }
}
