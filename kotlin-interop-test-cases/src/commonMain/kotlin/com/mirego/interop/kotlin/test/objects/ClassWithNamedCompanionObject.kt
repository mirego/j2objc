package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic

class ClassWithNamedCompanionObject {
    companion object Named {
        val companionString: String = "namedCompanionString"

        @JvmStatic
        fun companionJvmStaticFunction(): String = "jvmStaticFunction"
    }
}
