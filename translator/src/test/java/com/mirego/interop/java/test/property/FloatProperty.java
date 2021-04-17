package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithFloatProperty;

public class FloatProperty {

    public static float main(String[] args) {

        ClassWithFloatProperty classWithFloatProperty = new ClassWithFloatProperty(0.1f);

        return classWithFloatProperty.getFloatProperty();
    }
}
