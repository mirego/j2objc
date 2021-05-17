package com.mirego.interop.java.test.dataclass;

import com.mirego.interop.kotlin.test.dataclass.SimpleDataClass;

public class SimpleDataClassCopy {

    public static boolean main(String[] args) {
        SimpleDataClass simpleDataClass = new SimpleDataClass("dataClassName", 1);
        SimpleDataClass simpleDataClass2 = simpleDataClass.copy("dataClassName", 1);
        return simpleDataClass.equals(simpleDataClass2);
    }
}