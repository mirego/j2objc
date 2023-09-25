package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic

@Suppress("UtilityClassWithPublicConstructor")
class ClassWithCompanionObject {
    companion object {
        @Suppress("MayBeConst")
        val companionString: String =
            "companionString"

        @Suppress("FunctionOnlyReturningConstant")
        fun companionFunction(): String =
            "functionString"

        @JvmStatic
        @Suppress("FunctionOnlyReturningConstant")
        fun companionJvmStaticFunction(): String =
            "jvmStaticFunction"
    }
}
