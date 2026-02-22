package com.mirego.interop.java.test.property;

import com.mirego.interop.kotlin.test.property.EnumWithJvmFieldProperty;

public class PropertyAnnotatedWithJvmFieldInsideAnEnum {

  public static boolean main(String[] args) {
    EnumWithJvmFieldProperty enumWithJvmFieldProperty = EnumWithJvmFieldProperty.VALUE;
    return enumWithJvmFieldProperty.fieldWithCamelCaseName;
  }
}
