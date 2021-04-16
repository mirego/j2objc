package com.mirego.interop.java.test.dataclass;

import com.mirego.interop.kotlin.test.dataclass.SimpleDataClass;

public class SimpleDataClassGetter {

    public static String main(String[] args) {
        SimpleDataClass simpleDataClass = new SimpleDataClass("dataClassName", 1);
        return simpleDataClass.getName();
    }
}
