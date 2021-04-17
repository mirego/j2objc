package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithStringProperty;

public class AccessPropertyWithNilChk {

    public static String main(String[] args) {
        ClassWithStringProperty a = new ClassWithStringProperty("testString");
        return getThePropertyValue(a);
    }

    private static String getThePropertyValue(ClassWithStringProperty sourceForTheStringProperty) {
        // sourceForTheStringProperty may be null here so the compiler should generate nil_chk
        return sourceForTheStringProperty.getStringProperty();
    }

}
