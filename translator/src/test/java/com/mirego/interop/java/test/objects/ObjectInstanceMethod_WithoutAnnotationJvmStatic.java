package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class ObjectInstanceMethod_WithoutAnnotationJvmStatic {

    public static String main(String[] args) {
        String returnValue = ObjectWithMethod.INSTANCE.objectInstanceMethod_WithoutAnnotationJvmStatic();
        return returnValue;
    }
}
