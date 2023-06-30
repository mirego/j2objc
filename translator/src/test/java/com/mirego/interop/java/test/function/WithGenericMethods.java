package com.mirego.interop.java.test.function;

import java.util.ArrayList;
import java.util.List;

import com.mirego.interop.kotlin.test.generics.GenericFunctions;

public class WithGenericMethods {

  public static String main(String[] args) {
    List<Object> objects = new ArrayList<>();
    GenericFunctions.INSTANCE.validateNotNull(objects);

    InnerClass<String> innerClass = new InnerClass<>("a", "b", "c");

    return innerClass.getKeys()[0];
  }

  private static class InnerClass<T> {
    private final T[] keys;

    @SafeVarargs
    public InnerClass(T... keys) {
      this.keys = GenericFunctions.INSTANCE.validateNotNull(keys);
    }

    public T[] getKeys() {
      return keys;
    }
  }
}
