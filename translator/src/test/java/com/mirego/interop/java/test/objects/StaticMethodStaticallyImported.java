package com.mirego.interop.java.test.objects;

import static com.mirego.interop.kotlin.test.objects.ObjectWithMethod.staticMethodWithoutParamWithAnnotation;

public class StaticMethodStaticallyImported {

  public static String main(String[] args) {
    return staticMethodWithoutParamWithAnnotation();
  }
}
