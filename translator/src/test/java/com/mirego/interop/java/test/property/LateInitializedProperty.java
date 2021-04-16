package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithLateInitializedProperty;

public class LateInitializedProperty {

    public static String main(String[] args) {

        ClassWithLateInitializedProperty classWithBackingPropertyCustomSetter = new ClassWithLateInitializedProperty();

        return classWithBackingPropertyCustomSetter.getLateInitializedProperty();
    }
}
