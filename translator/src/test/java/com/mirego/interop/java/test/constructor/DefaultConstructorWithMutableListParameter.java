package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithMutableListParameter;
import java.util.Arrays;
import java.util.List;

public class DefaultConstructorWithMutableListParameter {

    public static ClassWithDefaultConstructorWithMutableListParameter main(String[] args) {

        ClassWithDefaultConstructorWithMutableListParameter defaultConstructorWithMutableListParameter =
            new ClassWithDefaultConstructorWithMutableListParameter(Arrays.asList(1));

        return defaultConstructorWithMutableListParameter;
    }
}
