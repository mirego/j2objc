package com.mirego.interop.java.test.interfaces;

import com.mirego.interop.kotlin.test.interfaces.InterfaceWithList;

import java.util.Arrays;
import java.util.List;

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
