package com.mirego.interop.java.test.nullsafety;

import com.mirego.interop.kotlin.test.nullsafety.ClassForNullSafety;

public class WithDoubleBangOperator {

    public static String main(String[] args) {

        ClassForNullSafety classForNullSafety = new ClassForNullSafety();

        return classForNullSafety.doubleBang();
    }
}
