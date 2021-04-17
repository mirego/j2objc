package com.mirego.interop.java.test.dataclass;

import com.mirego.interop.kotlin.test.dataclass.SimpleDataClass;

public class SimpleDataClassConstructor {

    public static SimpleDataClass main(String[] args) {
        SimpleDataClass simpleDataClass = new SimpleDataClass("dataClassName", 1);
        return simpleDataClass;
    }
}
