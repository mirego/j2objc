package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithBackingFieldCustomSetter;

public class BackingFieldWithCustomSetter {

    public static String main(String[] args) {

        ClassWithBackingFieldCustomSetter classWithBackingFieldCustomGetter = new ClassWithBackingFieldCustomSetter();
        classWithBackingFieldCustomGetter.setBackedField("backed");
        return classWithBackingFieldCustomGetter.getBackedField();
    }
}
