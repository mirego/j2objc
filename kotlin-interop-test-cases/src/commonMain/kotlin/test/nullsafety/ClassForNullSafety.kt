package com.mirego.interop.kotlin.test.nullsafety

public class ClassForNullSafety() {
    public fun doubleBang(): String {
        val a: String? = null
        return a!!
    }
}
