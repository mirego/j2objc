package com.mirego.interop.java.test.interfaces;

import com.mirego.interop.kotlin.test.interfaces.InterfaceWithGenerics;

public class WithGenerics {

    public static <T, U> InterfaceWithGenerics<T, U> process() {
        return new InterfaceWithGenericsImpl<>();
    }

    public static class InterfaceWithGenericsImpl<T, U> implements InterfaceWithGenerics<T, U> {

        @Override
        public U convert(T input) {
            return (U)input;
        }
    }

    public static int main(String[] args) {
        InterfaceWithGenerics<Integer, Integer> process = process();
        return process.convert(5);
    }
}
