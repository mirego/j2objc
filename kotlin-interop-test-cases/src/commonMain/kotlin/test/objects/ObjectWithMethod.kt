package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic
import kotlin.js.JsName

object ObjectWithMethod {

    fun staticMethodWithoutParam(): String {
        return "return"
    }

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

    @JvmStatic
    fun <T> staticMethodWithGenericParam(input: T): T {
        return input
    }
}
