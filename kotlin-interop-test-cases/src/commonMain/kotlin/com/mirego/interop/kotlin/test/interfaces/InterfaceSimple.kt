package com.mirego.interop.kotlin.test.interfaces

interface InterfaceSimple {
    fun apply() : Unit
}

class ClassImplementingSimpleInterface: InterfaceSimple {
    override fun apply() {
        // NO-OP
    }
}
