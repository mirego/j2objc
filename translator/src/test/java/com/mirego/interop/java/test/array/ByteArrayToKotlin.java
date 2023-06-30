package com.mirego.interop.java.test.array;

import com.mirego.interop.kotlin.test.arrays.ArrayBasics;

public class ByteArrayToKotlin {
  public static String main(String[] args) {
    ArrayBasics arrayBasics = new ArrayBasics(new byte[0]);

    byte b = arrayBasics.readValueAtIndex(arrayBasics.byteArray(1), 0);
    return String.valueOf(b);
  }
}
