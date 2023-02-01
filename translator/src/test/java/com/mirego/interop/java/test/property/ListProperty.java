package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithListProperty;

import java.util.Arrays;
import java.util.List;

public class ListProperty {

    public static List<String> main(String[] args) {

        ClassWithListProperty classWithListProperty = new ClassWithListProperty(Arrays.asList("test", "string"));

        return classWithListProperty.getListProperty();
    }
}
