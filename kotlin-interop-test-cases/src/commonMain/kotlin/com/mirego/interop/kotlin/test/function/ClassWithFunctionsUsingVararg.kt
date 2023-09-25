package com.mirego.interop.kotlin.test.function

import com.google.j2objc.kompat.KompatObjectiveCName

class ClassWithFunctionsUsingVararg {

    @KompatObjectiveCName("anyArgs:")
    fun any(vararg args: Any): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("booleanArrayArgs:")
    fun booleanArray(vararg args: Boolean): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("byteArrayArgs:")
    fun byteArray(vararg args: Byte): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("charArrayArgs:")
    fun charArray(vararg args: Char): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("doubleArrayArgs:")
    fun doubleArray(vararg args: Double): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("floatArrayArgs:")
    fun floatArray(vararg args: Float): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("intArrayArgs:")
    fun intArray(vararg args: Int): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("longArrayArgs:")
    fun longArray(vararg args: Long): String {
        return args.joinToString(",")
    }

    @KompatObjectiveCName("shortArrayArgs:")
    fun shortArray(vararg args: Short): String {
        return args.joinToString(",")
    }
}
