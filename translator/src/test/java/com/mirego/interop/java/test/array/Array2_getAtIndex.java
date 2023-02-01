package com.mirego.interop.java.test.array;

import com.mirego.interop.kotlin.test.arrays.ArrayBasics;

public class Array2_getAtIndex {

    public static String main(String[] args) {
        ArrayBasics arrayBasics = new ArrayBasics();

        String result = "Item at index[3]: " + arrayBasics.manyItemArray()[3];

        return result;
    }

}
