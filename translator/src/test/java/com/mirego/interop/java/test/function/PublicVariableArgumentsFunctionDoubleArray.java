package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithFunctionsUsingVararg;

public class PublicVariableArgumentsFunctionDoubleArray {

  public static String main(String[] args) {
    ClassWithFunctionsUsingVararg classWithFunctionsUsingVararg = new ClassWithFunctionsUsingVararg();
    return classWithFunctionsUsingVararg.doubleArray(1.1, 2.2, 3.3, 4.4);
  }
}
