package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ClassWithNamedCompanionObject;

public class WithNamedCompanionObject {

  public static String main(String[] args) {
    String companionStringWithJvmField = ClassWithNamedCompanionObject.companionStringWithJvmField;
    String companionString = ClassWithNamedCompanionObject.Named.getCompanionString();
    String companionJvmStaticFunctionString = ClassWithNamedCompanionObject.companionJvmStaticFunction();
    return String.join("_", companionStringWithJvmField, companionString, companionJvmStaticFunctionString);
  }
}
