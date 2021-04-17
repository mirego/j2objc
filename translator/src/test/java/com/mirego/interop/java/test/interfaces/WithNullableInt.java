package com.mirego.interop.java.test.interfaces;

import com.mirego.interop.kotlin.test.interfaces.InterfaceWithNullableInt;

public class WithNullableInt {

    public static class WithNullableIntImplementation implements InterfaceWithNullableInt {
        @Override
        public Integer convert(Integer inputNullableInteger) {
            return inputNullableInteger;
        }
    }

    public static Integer main(String[] args) {
        WithNullableIntImplementation withNullableInt = new WithNullableIntImplementation();
        return withNullableInt.convert((Integer) 1);
    }
}
