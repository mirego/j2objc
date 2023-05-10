package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;

public class PublicFunctionReturningUnit {

  public static void main(String[] args) {

    ClassWithPublicFunctions classWithPublicFunction = new ClassWithPublicFunctions();

    classWithPublicFunction.returnUnit();
  }
}
