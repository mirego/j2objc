package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithFunctionsUsingVararg;

public class PublicVariableArgumentsFunctionByteArray {

  public static String main(String[] args) {
    ClassWithFunctionsUsingVararg classWithFunctionsUsingVararg = new ClassWithFunctionsUsingVararg();
    return classWithFunctionsUsingVararg.byteArray((byte) 1, (byte) 2, (byte) 3, (byte) 4);
  }
}
