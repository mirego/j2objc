package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithFunctionsUsingVararg;

public class PublicVariableArgumentsFunctionIntArray {

  public static String main(String[] args) {
    ClassWithFunctionsUsingVararg classWithFunctionsUsingVararg = new ClassWithFunctionsUsingVararg();
    return classWithFunctionsUsingVararg.intArray(1, 2, 3, 4);
  }
}
