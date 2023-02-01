package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

import java.util.Arrays;
import java.util.List;

public class StaticMethodWithListParamWithAnnotation {

    public static List<Integer> main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> returnValue = ObjectWithMethod.staticMethodWithListParamWithAnnotation(list);
        return returnValue;
    }
}
