package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethod_WithoutParam_WithAnnotationJvmStatic {

    public static String main(String[] args) {
        String returnValue = ObjectWithMethod.staticMethod_WithoutParam_WithAnnotationJvmStatic();
        return returnValue;
    }
}
