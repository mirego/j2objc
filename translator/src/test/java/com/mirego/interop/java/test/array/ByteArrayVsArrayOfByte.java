package com.mirego.interop.java.test.array;

import com.mirego.interop.kotlin.test.arrays.ArrayBasics;

public class ByteArrayVsArrayOfByte {
  public static String main(String[] args) {
    ArrayBasics arrayBasics = new ArrayBasics();

    Byte[] arrayOfByte = arrayBasics.arrayOfByte();
    byte[] byteArray = arrayBasics.byteArray();

    return "OK";
  }
}
