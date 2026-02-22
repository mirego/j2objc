package com.mirego.interop.java.test.function;

import static com.mirego.interop.kotlin.test.function.KotlinFileWithTopLevelFunctionKt.aTopLevelFunction;

public class TopLevelFunctionStaticallyImported {

  public static String main(String[] args) {
    return aTopLevelFunction("echoed value from aTopLevelFunction");
  }
}
