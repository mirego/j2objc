package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ClassWithCompanionObject;

public class WithCompanionObject {

  public static String main(String[] args) {
    String companionString = ClassWithCompanionObject.Companion.getCompanionString();
    String companionFunctionString = ClassWithCompanionObject.Companion.companionFunction();
    return companionString + companionFunctionString;
  }
}
