package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethodWithoutParam {

    public static String main(String[] args) {
        return ObjectWithMethod.INSTANCE.staticMethodWithoutParam();
    }
}
