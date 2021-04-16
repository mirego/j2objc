package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithCharSequenceProperty;

public class CharSequenceProperty {

    public static CharSequence main(String[] args) {
        ClassWithCharSequenceProperty classWithCharSequenceProperty = new ClassWithCharSequenceProperty("1000");
        return classWithCharSequenceProperty.getCharSequenceProperty();
    }
}
