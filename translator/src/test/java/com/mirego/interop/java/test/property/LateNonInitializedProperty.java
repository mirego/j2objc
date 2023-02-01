package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithLateNonInitializedProperty;

public class LateNonInitializedProperty {

    public static String main(String[] args) {

        ClassWithLateNonInitializedProperty classWithLateNonInitializedProperty = new ClassWithLateNonInitializedProperty();

        return classWithLateNonInitializedProperty.getLateNonInitializedProperty();
    }
}
