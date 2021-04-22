package com.mirego.interop.java.test.array;

import com.mirego.interop.kotlin.test.arrays.ArrayBasics;

public class Array3_setAtIndex {

    public static String main(String[] args) {
        ArrayBasics arrayBasics = new ArrayBasics();

        String[] manyItemArray = arrayBasics.manyItemArray();
        String originalValue = manyItemArray[3];

        arrayBasics.manyItemArray()[3] = "ZZZ";

        // Direct read from java
        String result = "From Java --> Item at index[3]: " + manyItemArray[3];
        result = result + "\n";

        // Read back from kotlin
        result = result +
                "From Kotlin --> Item at index[3]: " + arrayBasics.readValueAtIndex(manyItemArray, 3);

        arrayBasics.manyItemArray()[3] = originalValue;

        return result;
    }

}
