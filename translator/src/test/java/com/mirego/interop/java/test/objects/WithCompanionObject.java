package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ClassWithCompanionObject;

public class WithCompanionObject {

  public static String main(String[] args) {
    ClassWithCompanionObject o = new ClassWithCompanionObject();

    String instanceString = o.getInstanceString();
    String instanceStringAsJvmField = o.instanceStringAsJvmField;

    String companionString = ClassWithCompanionObject.Companion.getCompanionString();
    String companionStringAsJvmField = ClassWithCompanionObject.companionStringAsJvmField;
    String companionFunctionString = ClassWithCompanionObject.Companion.companionFunction();
    String companionJvmStaticFunctionString = ClassWithCompanionObject.companionJvmStaticFunction();
    return String.join("_", instanceString, instanceStringAsJvmField, companionString, companionStringAsJvmField, companionFunctionString, companionJvmStaticFunctionString);
  }
}
