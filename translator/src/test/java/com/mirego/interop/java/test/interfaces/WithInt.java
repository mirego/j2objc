package com.mirego.interop.java.test.interfaces;

import com.mirego.interop.kotlin.test.interfaces.InterfaceWithInt;

public class WithInt {

    public static class WithIntImplementation implements InterfaceWithInt {
        @Override
        public int convert(int inputInt) {
            return inputInt;
        }
    }

    public static int main(String[] args) {
        WithIntImplementation withInt = new WithIntImplementation();
        return withInt.convert(1);
    }
}
