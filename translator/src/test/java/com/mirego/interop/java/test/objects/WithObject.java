package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ClassWithObject;

public class WithObject {

  public static String main(String[] args) {
    return ClassWithObject.Named.INSTANCE.getObjectString();
  }
}
