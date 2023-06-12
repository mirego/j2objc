package com.mirego.interop.java.test.function;

import com.mirego.interop.kotlin.test.function.ClassWithPublicFunctions;
import com.mirego.interop.kotlin.test.interfaces.InterfaceWithInt;

public class PublicFunctionUsingKotlinTypeAsParameter {

  public PublicFunctionUsingKotlinTypeAsParameter(ClassWithPublicFunctions constructorParam) {
  }

  public PublicFunctionUsingKotlinTypeAsParameter(ClassWithPublicFunctions constructorParam1, InterfaceWithInt constructorParam2) {
  }

  public void aMethodUsingASingleTypeKotlin(ClassWithPublicFunctions param) {
  }

  public void aMethodUsingManyTypeKotlin(ClassWithPublicFunctions param1, InterfaceWithInt param2) {
  }

  public static String main(String[] args) {
    ClassWithPublicFunctions classWithPublicFunctions = new ClassWithPublicFunctions();

    String name = classWithPublicFunctions.methodWithObjCName("test");

    return classWithPublicFunctions.returnString() + name;
  }
}
