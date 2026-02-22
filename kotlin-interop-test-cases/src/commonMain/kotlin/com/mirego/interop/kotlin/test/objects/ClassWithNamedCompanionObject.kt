package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

@Suppress("UtilityClassWithPublicConstructor")
class ClassWithNamedCompanionObject {
    companion object Named {
        @JvmField
        @Suppress("MayBeConst", "MayBeConstant")
        val companionStringWithJvmField = "companionStringWithJvmField"

        @Suppress("MayBeConst")
        val companionString: String =
            "namedCompanionString"

        @JvmStatic
        @Suppress("FunctionOnlyReturningConstant")
        fun companionJvmStaticFunction(): String =
            "jvmStaticFunction"
    }
}
