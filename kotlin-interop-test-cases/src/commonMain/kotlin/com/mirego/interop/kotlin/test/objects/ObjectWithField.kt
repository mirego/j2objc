package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

object ObjectWithField {

    @Suppress("MayBeConst")
    val companionString: String =
        "companionString"

    @JvmField
    @Suppress("MayBeConst", "MayBeConstant")
    val companionStringAsJvmField: String =
        "companionStringAsJvmField"

    @Suppress("FunctionOnlyReturningConstant")
    fun companionFunction(): String =
        "functionString"

    @JvmStatic
    @Suppress("FunctionOnlyReturningConstant")
    fun companionJvmStaticFunction(): String =
        "jvmStaticFunction"
}
