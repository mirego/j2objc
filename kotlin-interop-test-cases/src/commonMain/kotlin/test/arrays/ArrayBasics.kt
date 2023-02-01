package com.mirego.interop.kotlin.test.arrays

import kotlin.js.JsName

public class ArrayBasics {

    val propertySingleItemArray = arrayOf("a");

    val propertyManyItemArray = arrayOf("a", "b", "c", "d", "e");

    fun emptyArray(): Array<String> {
        return arrayOf<String>()
    }

    fun singleItemArray(): Array<String> {
        return propertySingleItemArray
    }

    fun manyItemArray(): Array<String> {
        return propertyManyItemArray
    }

    @JsName("readValueAtIndex")
    fun readValueAtIndex(theArray: Array<String>, theIndex: Int): String {
        return theArray[theIndex]
    }

}
