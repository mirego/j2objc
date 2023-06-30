package com.mirego.interop.java.test.interfaces;

import javax.annotation.Nonnull;

import com.mirego.interop.kotlin.test.interfaces.KotlinInterfaceWithStringProperty;

public class WithStringProperty {

  public static class WithStringPropertyImplementation implements JavaInterfaceThatExtendsAKotlinInterfaceWithAProperty {
    @Nonnull
    @Override
    public String getKey() {
      return "this is the value of my key";
    }

    @Override
    public String getValue() {
      return "This is the value";
    }
  }

  public interface JavaInterfaceThatExtendsAKotlinInterfaceWithAProperty extends KotlinInterfaceWithStringProperty {
    String getValue();
  }

  public static String main(String[] args) {
    WithStringPropertyImplementation withStringPropertyImplementation = new WithStringPropertyImplementation();
    return withStringPropertyImplementation.getKey();
  }
}
