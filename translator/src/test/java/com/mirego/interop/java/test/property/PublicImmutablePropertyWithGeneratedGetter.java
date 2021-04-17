package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithPublicImmutableProperty;

public class PublicImmutablePropertyWithGeneratedGetter {

    public static String main(String[] args) {

        ClassWithPublicImmutableProperty immutablePropertyClass = new ClassWithPublicImmutableProperty("immutableProperty");

        return immutablePropertyClass.getImmutableProperty();
    }
}
