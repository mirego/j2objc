package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithFunctionsUsingVararg;

public class PublicVariableArgumentsFunctionShortArray {

  public static String main(String[] args) {
    ClassWithFunctionsUsingVararg classWithFunctionsUsingVararg = new ClassWithFunctionsUsingVararg();
    return classWithFunctionsUsingVararg.shortArray((short) 1, (short) 2, (short) 3, (short) 4);
  }
}
