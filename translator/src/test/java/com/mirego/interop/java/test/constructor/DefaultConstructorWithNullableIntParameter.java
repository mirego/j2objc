package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructorWithNullableIntParameter;

public class DefaultConstructorWithNullableIntParameter {

    public static ClassWithDefaultConstructorWithNullableIntParameter main(String[] args) {

        Integer nullableInteger = 1;
        ClassWithDefaultConstructorWithNullableIntParameter defaultConstructorWithNullableIntParameter =
            new ClassWithDefaultConstructorWithNullableIntParameter(nullableInteger);

        return defaultConstructorWithNullableIntParameter;
    }
}
