package com.mirego.interop.java.test.objects;

import static com.mirego.interop.kotlin.test.objects.ClassWithCompanionObject.companionJvmStaticFunction;
import static com.mirego.interop.kotlin.test.objects.ObjectWithMethod.staticMethodWithoutParamWithAnnotation;

public class AccessingJvmStaticWithStaticImport {
  public static String main(String[] args) {
    String objectFunction = staticMethodWithoutParamWithAnnotation();
    String companionFunction = companionJvmStaticFunction();
    return String.join("_", objectFunction, companionFunction);
  }
}
