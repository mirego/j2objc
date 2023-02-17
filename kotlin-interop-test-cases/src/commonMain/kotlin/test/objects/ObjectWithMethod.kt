package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic

object ObjectWithMethod {
    @JvmStatic
    fun staticMethod_WithoutParam_WithAnnotationJvmStatic(): String {
        return "Inside ObjectWithMethod.staticMethod_WithoutParam_WithAnnotationJvmStatic()"
    }

    @JvmStatic
    fun staticMethod_WithStringParam_WithAnnotationJvmStatic(input: String): String {
        return "Inside staticMethod_WithStringParam_WithAnnotationJvmStatic() - returning input: " + input
    }

    @JvmStatic
    fun <T> staticMethod_WithGenericParam(input: T): T {
        return input
    }

    fun objectInstanceMethod_WithoutAnnotationJvmStatic(): String {
        return "Inside ObjectWithMethod.objectInstanceMethodWithoutAnnotation_JvmStatic()"
    }

}
