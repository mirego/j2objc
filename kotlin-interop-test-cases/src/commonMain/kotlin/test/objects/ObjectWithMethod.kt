package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic
import kotlin.js.JsName

object ObjectWithMethod {
    @JvmStatic
    fun staticMethodWithoutParamWithAnnotation(): String {
        return "return"
    }

    @JvmStatic
    @JsName("staticMethodWithStringParamWithAnnotation")
    fun staticMethodWithStringParamWithAnnotation(input: String): String {
        return input
    }

    @JvmStatic
    fun staticMethodWithListParamWithAnnotation(input: List<Int>): List<Int> {
        return input
    }
}
