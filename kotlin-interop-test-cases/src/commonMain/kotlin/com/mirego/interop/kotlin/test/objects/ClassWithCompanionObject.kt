package com.mirego.interop.kotlin.test.objects

import kotlin.jvm.JvmStatic

class ClassWithCompanionObject {
    companion object {
        val companionString : String = "companionString"

        fun companionFunction() : String = "functionString"

        @JvmStatic
        fun companionJvmStaticFunction(): String = "jvmStaticFunction"
    }
}
