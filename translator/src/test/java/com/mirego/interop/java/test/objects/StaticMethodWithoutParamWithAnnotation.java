package com.mirego.interop.java.test.objects;

import com.mirego.interop.kotlin.test.objects.ObjectWithMethod;

public class StaticMethodWithoutParamWithAnnotation {

  public static String main(String[] args) {
    String returnValue = ObjectWithMethod.staticMethodWithoutParamWithAnnotation();
    return returnValue;
  }
}
