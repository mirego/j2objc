package com.mirego.interop.kotlin.test.objects

class ClassWithCompanionObject {
    companion object {
        val companionString : String = "companionString"
        fun companionFunction() : String = "functionString"
    }
}
