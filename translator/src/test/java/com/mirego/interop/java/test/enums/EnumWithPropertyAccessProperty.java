package com.mirego.interop.java.test.enums;

import com.mirego.interop.kotlin.test.enums.EnumWithProperty;

public class EnumWithPropertyAccessProperty {

    public static String main(String[] args) {
        EnumWithProperty enumWithProperty = EnumWithProperty.ENUMVALUE1;
        return enumWithProperty.getContent();
    }
}