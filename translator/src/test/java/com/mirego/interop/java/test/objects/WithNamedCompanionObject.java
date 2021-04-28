package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ClassWithNamedCompanionObject;

public class WithNamedCompanionObject {

  public static String main(String[] args) {
    String companionString = ClassWithNamedCompanionObject.Named.getCompanionString();
    return companionString;
  }
}
