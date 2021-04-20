package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithIntProperty;

public class IntProperty {

    public static int main(String[] args) {

        ClassWithIntProperty classWithIntProperty = new ClassWithIntProperty(1);

        return classWithIntProperty.getIntProperty();
    }
}
