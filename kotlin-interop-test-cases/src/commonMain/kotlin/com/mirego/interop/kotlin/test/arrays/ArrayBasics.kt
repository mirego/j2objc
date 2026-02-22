package com.mirego.interop.kotlin.test.arrays

import kotlin.js.JsName

class ArrayBasics {

    private val propertySingleItemArray = arrayOf("a")

    private val propertyManyItemArray = arrayOf("a", "b", "c", "d", "e")

    fun emptyArray(): Array<String> {
        return arrayOf()
    }

    fun singleItemArray(): Array<String> {
        return propertySingleItemArray
    }

    fun manyItemArray(): Array<String> {
        return propertyManyItemArray
    }

    fun byteArray(): ByteArray {
        return ByteArray(0)
    }

    fun byteArray(size: Int): ByteArray {
        return ByteArray(size)
    }

    fun arrayOfByte(): Array<Byte> {
        return arrayOf()
    }

    @JsName("readValueAtIndex")
    fun readValueAtIndex(theArray: Array<String>, theIndex: Int): String {
        return theArray[theIndex]
    }

    fun readValueAtIndex(byteArray: ByteArray, index: Int): Byte {
        return byteArray[index]
    }
}
