package com.mirego.interop.java.test.classes;

import com.mirego.interop.kotlin.test.interfaces.ClassImplementingSimpleInterface;
import com.mirego.interop.kotlin.test.interfaces.InterfaceSimple;

public class CallingGetClassOnInstanceOfInterface {
  public static boolean main(String[] args) {
    ClassImplementingSimpleInterface classImplementingSimpleInterface = getAsClass();
    InterfaceSimple interfaceSimple = getAsInterface();
    Class<? extends ClassImplementingSimpleInterface> fromClass = classImplementingSimpleInterface.getClass();
    Class<? extends InterfaceSimple> fromInterface = interfaceSimple.getClass();
    return fromClass.equals(fromInterface);
  }

  private static InterfaceSimple getAsInterface() {
    return new ClassImplementingSimpleInterface();
  }

  private static ClassImplementingSimpleInterface getAsClass() {
    return new ClassImplementingSimpleInterface();
  }
}
