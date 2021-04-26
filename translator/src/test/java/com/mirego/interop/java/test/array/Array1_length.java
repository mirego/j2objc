package com.mirego.interop.java.test.array;

import com.mirego.interop.kotlin.test.arrays.ArrayBasics;

public class Array1_length {

    public static String main(String[] args) {
        ArrayBasics arrayBasics = new ArrayBasics();

        String[] emptyArray = arrayBasics.emptyArray();

        return "Empty: " + arrayBasics.emptyArray().length + " - "
                + "Single: " + arrayBasics.singleItemArray().length + " - "
                + "Many: " + arrayBasics.manyItemArray().length;

    }

}
