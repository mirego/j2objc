package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic

@Suppress("UtilityClassWithPublicConstructor")
class ClassWithNamedCompanionObject {
    companion object Named {
        @Suppress("MayBeConst")
        val companionString: String =
            "namedCompanionString"

        @JvmStatic
        @Suppress("FunctionOnlyReturningConstant")
        fun companionJvmStaticFunction(): String =
            "jvmStaticFunction"
    }
}
