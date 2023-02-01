package com.mirego.interop.java.test.enums;

import com.mirego.interop.kotlin.test.enums.SimpleEnum;

public class SimpleEnumValues {

    public static String main(String[] args) {
        String combinedEnumNames = "";
        for (SimpleEnum value : SimpleEnum.values()) {
            combinedEnumNames += value.name();
        }
        return combinedEnumNames;
    }
}
