package com.mirego.interop.java.test.classes;

import com.mirego.interop.kotlin.test.constructor.ClassWithDefaultConstructor;
import com.mirego.interop.kotlin.test.interfaces.InterfaceSimple;

public class KotlinClassVariable {

  public static boolean main(String[] args) {
    String className = ClassWithDefaultConstructor.class.getName();
    String interfaceName = InterfaceSimple.class.getName();
    return className.endsWith("ClassWithDefaultConstructor")
        && interfaceName.endsWith("InterfaceSimple");
  }
}
