package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithField;

public class WithField {

  public static String main(String[] args) {
    String companionString = ObjectWithField.INSTANCE.getCompanionString();
    String companionStringAsJvmField = ObjectWithField.companionStringAsJvmField;
    String companionFunction = ObjectWithField.INSTANCE.companionFunction();
    String companionJvmStaticFunction = ObjectWithField.companionJvmStaticFunction();
    return String.join("_", companionString, companionStringAsJvmField, companionFunction, companionJvmStaticFunction);
  }
}
