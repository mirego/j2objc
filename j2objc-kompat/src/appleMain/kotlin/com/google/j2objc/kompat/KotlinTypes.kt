@file:Suppress("unused")

package com.google.j2objc.kompat

// This file contains dummy code to make sure required types are added to `J2ObjC_kotlinTypes.h`

interface J2ObjCKompatDummy {
    fun array(): Array<Any>
    fun booleanArray(): BooleanArray
    fun byteArray(): ByteArray
    fun charArray(): CharArray
    fun doubleArray(): DoubleArray
    fun floatArray(): FloatArray
    fun intArray(): IntArray
    fun longArray(): LongArray
    fun shortArray(): ShortArray
    fun hashSet(): HashSet<Any>
    fun hashMap(): HashMap<Any, Any>
}

interface J2ObjCKompatDummyComparable : Comparable<Any>
