package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithNullableBooleanProperty;

public class NullableBooleanProperty {

    public static boolean main(String[] args) {

        ClassWithNullableBooleanProperty classWithNullableBooleanProperty = new ClassWithNullableBooleanProperty(null);

        return classWithNullableBooleanProperty.getNullableBoolean();
    }
}
