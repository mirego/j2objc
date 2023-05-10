package com.mirego.interop.java.test.interfaces;

import java.util.Arrays;
import java.util.List;

import com.mirego.interop.kotlin.test.interfaces.InterfaceWithList;

public class WithList {

  public static class WithListImplementation<E> implements InterfaceWithList {
    @Override
    public List convert(List inputList) {
      return inputList;
    }
  }

  public static List main(String[] args) {
    WithListImplementation withList = new WithListImplementation<Integer>();
    return withList.convert(Arrays.asList(Integer.valueOf(1)));
  }
}
