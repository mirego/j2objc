package com.mirego.interop.kotlin.test.interfaces

interface InterfaceSimple {
    fun apply()
}

class ClassImplementingSimpleInterface : InterfaceSimple {
    override fun apply() {
        // NO-OP
    }
}
