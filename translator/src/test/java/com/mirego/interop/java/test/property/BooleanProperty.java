package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithBooleanProperty;

public class BooleanProperty {

    public static boolean main(String[] args) {

        ClassWithBooleanProperty classWithBooleanProperty = new ClassWithBooleanProperty(false);

        return classWithBooleanProperty.getBooleanProperty();
    }
}
