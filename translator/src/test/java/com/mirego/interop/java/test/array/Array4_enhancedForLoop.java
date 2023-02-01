package com.mirego.interop.java.test.array;

import com.mirego.interop.kotlin.test.arrays.ArrayBasics;

public class Array4_enhancedForLoop {

    public static String main(String[] args) {
        ArrayBasics arrayBasics = new ArrayBasics();

        String result = "[";
        for (String s : arrayBasics.manyItemArray()) {
            result = result + s;
        }
        result = result + "]";
        return result;
    }
}
