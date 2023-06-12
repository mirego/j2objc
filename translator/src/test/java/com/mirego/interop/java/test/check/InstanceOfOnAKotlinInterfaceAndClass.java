package com.mirego.interop.java.test.check;

import com.mirego.interop.kotlin.test.interfaces.ClassWithGenerics;
import com.mirego.interop.kotlin.test.interfaces.InterfaceWithGenerics;

public class InstanceOfOnAKotlinInterfaceAndClass {

  public static class AJavaClass extends ClassWithGenerics<String, String> {
  }

  public static boolean main(String[] args) {
    InterfaceWithGenerics<String, String> anObjectTypedAsAKotlinInterface = null;
    AJavaClass aJavaClass = new AJavaClass();
    if (aJavaClass instanceof InterfaceWithGenerics) {
      return true;
    }

    if (aJavaClass instanceof ClassWithGenerics) {
      return true;
    }

    return anObjectTypedAsAKotlinInterface instanceof AJavaClass;
  }
}

// Work-around for issue where the translated code tries to call a non-existing function
/*-[
void CommonClassWithGenerics_init(CommonClassWithGenerics *self) {
  (void)[self init];
}
]-*/
