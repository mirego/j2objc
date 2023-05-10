package com.mirego.interop.java.test.constructor;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructor;
import com.mirego.interop.kotlin.test.interfaces.InterfaceSimple;

public class KotlinClassVariable {

  public static String main(String[] args) {
    String className = ClassWithDefaultConstructor.class.getName();
    String interfaceName = InterfaceSimple.class.getName();
    return className + " " + interfaceName;
  }
}
