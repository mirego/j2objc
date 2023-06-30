package com.mirego.interop.java.test.function;

import java.util.ArrayList;

import com.mirego.interop.kotlin.test.extensions.ExtensionAndGlobalFunctionsKt;

public class CallingGlobalFunctions {
  public static String main(String[] args) {
    String globalFunction = ExtensionAndGlobalFunctionsKt.getString("globalFunction", "getString");
    String globalExtensionFunction = ExtensionAndGlobalFunctionsKt.getWithMessage("globalExtensionFunction", "getWithMessage");
    boolean isBig = ExtensionAndGlobalFunctionsKt.isBig(new ArrayList<>());
    return String.join("_", globalFunction, globalExtensionFunction, String.valueOf(isBig));
  }
}
