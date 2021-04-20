package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithPublicMutableProperty;

public class PublicMutablePropertyWithGeneratedSetter {

    public static String main(String[] args) {

        ClassWithPublicMutableProperty mutablePropertyClass = new ClassWithPublicMutableProperty("mutableProperty");
        mutablePropertyClass.setMutableProperty("mutatedMutableProperty");
        return mutablePropertyClass.getMutableProperty();
    }
}
