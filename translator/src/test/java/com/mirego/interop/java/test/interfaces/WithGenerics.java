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

        @Override
        public <V> V convertWithFunctionGeneric(V v) {
            return v;
        }

        @Override
        public <W> W convertWithAnotherFunctionGeneric(W w) {
            return w;
        }
    }

    public static Integer main(String[] args) {
        InterfaceWithGenerics<Integer, Integer> process = process();
        return process.convert(5) + process.convertWithFunctionGeneric(3) + process.convertWithAnotherFunctionGeneric(1);
    }
}
