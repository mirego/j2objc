package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.ClassWithJvmFieldProperty;

public class PropertyAnnotatedWithJvmField {

  public static String main(String[] args) {
    ClassWithJvmFieldProperty classWithJvmFieldProperty = new ClassWithJvmFieldProperty();
    return classWithJvmFieldProperty.name;
  }
}
