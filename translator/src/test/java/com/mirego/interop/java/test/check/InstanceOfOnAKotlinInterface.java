package com.mirego.interop.java.test.check;

import com.mirego.interop.kotlin.test.interfaces.InterfaceWithGenerics;

public class InstanceOfOnAKotlinInterface {

  public static class AJavaClass {
  }

  public static boolean main(String[] args) {
    InterfaceWithGenerics anObjectTypedAsAKotlinInterface = null;
    return anObjectTypedAsAKotlinInterface instanceof AJavaClass;
  }
}
