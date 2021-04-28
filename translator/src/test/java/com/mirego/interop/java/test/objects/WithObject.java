package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ClassWithObject;
import com.mirego.interop.kotlin.test.objects.ClassWithObject.Named;

public class WithObject {

  public static String main(String[] args) {
    String objectString = ClassWithObject.Named.INSTANCE.getObjectString();
    return objectString;
  }
}
