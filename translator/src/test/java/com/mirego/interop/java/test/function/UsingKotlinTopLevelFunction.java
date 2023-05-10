package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.KotlinFileWithTopLevelFunctionKt;

public class UsingKotlinTopLevelFunction {
  public static String main(String[] args) {
    return KotlinFileWithTopLevelFunctionKt.aTopLevelFunction("hello");
  }
}
