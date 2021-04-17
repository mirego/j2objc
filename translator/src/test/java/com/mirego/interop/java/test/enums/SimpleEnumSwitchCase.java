package com.mirego.interop.java.test.enums;

import com.mirego.interop.kotlin.test.enums.SimpleEnum;

import static com.mirego.interop.kotlin.test.enums.SimpleEnum.*;

public class SimpleEnumSwitchCase {

    public static int main(String[] args) {
        SimpleEnum testEnum = ENUMVALUE1;
        switch(testEnum)
        {
            case ENUMVALUE1:
                return 1;

            case ENUM_VALUE2:
                return 2;

            case ENUM_VALUE_3:
                return 3;

            default:
                return 4;
        }
    }
}
