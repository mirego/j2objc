package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.KotlinFileWithTopLevelFunctionKt;
import com.mirego.interop.kotlin.test.function.KotlinTopLevelFunctionWithOverriddenJvmFilenameOVERRIDE;

public class UsingKotlinTopLevelFunction {
  public static String main(String[] args) {
    return KotlinFileWithTopLevelFunctionKt.aTopLevelFunction("hello") +
        "-"
        + KotlinTopLevelFunctionWithOverriddenJvmFilenameOVERRIDE.topLevelFunctionInOverriddenJvmFilename();
  }
}
