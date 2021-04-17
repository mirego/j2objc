package com.mirego.interop.java.test.dataclass;

import com.mirego.interop.kotlin.test.dataclass.MutableDataClass;

public class MutableDataClassSetter {

    public static String main(String[] args) {
        MutableDataClass mutableDataClass = new MutableDataClass("dataClassName", 1);
        mutableDataClass.setName("dataClassName-updated");
        return mutableDataClass.getName();
    }
}
