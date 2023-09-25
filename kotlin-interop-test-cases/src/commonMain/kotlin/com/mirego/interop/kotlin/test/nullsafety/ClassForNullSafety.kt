package com.mirego.interop.kotlin.test.nullsafety

class ClassForNullSafety {
    fun doubleBang(): String {
        val a: String? = null
        return a!!
    }
}
