package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.StandAloneObject;

public class StandAloneObjectInstance {
  public static String main(String[] args) {
    return StandAloneObject.INSTANCE.getClass().getSimpleName();
  }
}
