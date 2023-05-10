package com.mirego.interop.java.test.interfaces;

import com.mirego.interop.kotlin.test.interfaces.KotlinInterfaceWithIntProperty;

public class WithIntProperty {
  public static class WithIntPropertyImplementation implements KotlinInterfaceWithIntProperty {

    @Override
    public int getCount() {
      return 42;
    }
  }

  public static String main(String[] args) {
    WithIntPropertyImplementation withIntPropertyImplementation = new WithIntPropertyImplementation();
    return String.valueOf(withIntPropertyImplementation.getCount());
  }
}
