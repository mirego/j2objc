package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethod_WithGenericParam {

    public static String main(String[] args) {
        String testString = "stringGeneric";
        return ObjectWithMethod.staticMethod_WithGenericParam(testString);
    }
}
