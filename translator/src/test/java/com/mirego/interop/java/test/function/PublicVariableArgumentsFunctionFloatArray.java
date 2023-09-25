package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithFunctionsUsingVararg;

public class PublicVariableArgumentsFunctionFloatArray {

  public static String main(String[] args) {
    ClassWithFunctionsUsingVararg classWithFunctionsUsingVararg = new ClassWithFunctionsUsingVararg();
    return classWithFunctionsUsingVararg.floatArray(1.1F, 2.2F, 3.3F, 4.4F);
  }
}
