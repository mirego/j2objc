package com.mirego.interop.java.test.interfaces;

import com.mirego.interop.kotlin.test.interfaces.InterfaceSimple;
import com.mirego.interop.kotlin.test.interfaces.InterfaceWithInt;
import com.mirego.interop.kotlin.test.interfaces.InterfaceWithList;
import com.mirego.interop.kotlin.test.interfaces.InterfaceWithNullableInt;

public class InstanceOfOnKotlinProvidedInterfaces {

  public static boolean main(String[] args) {
    InterfaceSimple myObject = getMyObject();
    //if (myObject instanceof InterfaceWithInt) {
       ((InterfaceWithInt) myObject).convert(1);
    //}

    InterfaceWithNullableInt withList = (InterfaceWithNullableInt) myObject;
    withList.convert(1);

    return true;
  }

  public static InterfaceSimple getMyObject() {
    return new MyJavaClassExtendingKotlinClass();
  }

  public static class MyJavaClassExtendingKotlinClass implements InterfaceSimple, InterfaceWithInt {
    @Override
    public void apply() {

    }

    @Override
    public int convert(int inputInt) {
      return 0;
    }
  }
}
