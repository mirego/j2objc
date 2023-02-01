package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithListParameter;
import java.util.Arrays;

public class DefaultConstructorWithListParameter {

    public static ClassWithDefaultConstructorWithListParameter main(String[] args) {

        ClassWithDefaultConstructorWithListParameter defaultConstructorWithListParameter =
            new ClassWithDefaultConstructorWithListParameter(Arrays.asList(1));

        return defaultConstructorWithListParameter;
    }
}
