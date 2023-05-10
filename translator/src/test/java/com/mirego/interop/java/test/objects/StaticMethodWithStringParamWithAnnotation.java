package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethodWithStringParamWithAnnotation {

  public static String main(String[] args) {
    String returnValue = ObjectWithMethod.staticMethodWithStringParamWithAnnotation("stringAsParam");
    return returnValue;
  }
}
