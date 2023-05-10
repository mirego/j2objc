package com.mirego.interop.java.test.imports;

import com.mirego.interop.kotlin.test.enums.SimpleEnum;

public class ImportTest_ExposingKotlinTypeInPublicApi {

  public SimpleEnum getValue() {
    return SimpleEnum.ENUMVALUE1;
  }

  public static String main(String[] args) {
    return new ImportTest_ExposingKotlinTypeInPublicApi().getValue().toString();
  }
}
