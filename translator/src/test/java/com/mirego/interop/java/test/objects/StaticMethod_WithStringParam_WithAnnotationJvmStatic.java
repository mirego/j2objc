package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethod_WithStringParam_WithAnnotationJvmStatic {

    public static String main(String[] args) {
        String returnValue = ObjectWithMethod.staticMethod_WithStringParam_WithAnnotationJvmStatic("stringAsParam");
        return returnValue;
    }
}
