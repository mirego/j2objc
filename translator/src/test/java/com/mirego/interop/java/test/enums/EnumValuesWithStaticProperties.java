package com.mirego.interop.java.test.enums;

import com.mirego.interop.kotlin.test.enums.EnumWithStaticProperty;
public class EnumValuesWithStaticProperties {

  public static String main(String[] args) {
    String combinedEnumNames = "";
    for (EnumWithStaticProperty value : EnumWithStaticProperty.values()) {
      combinedEnumNames += value.name();
    }
    return combinedEnumNames;
  }
}
