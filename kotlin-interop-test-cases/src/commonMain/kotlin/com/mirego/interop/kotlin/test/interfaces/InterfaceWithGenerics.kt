package com.mirego.interop.kotlin.test.interfaces

interface InterfaceWithGenerics<T, U> {
    fun convert(input: T): U

    fun <V> convertWithFunctionGeneric(otherInput: V): V

    fun <W> convertWithAnotherFunctionGeneric(anotherInput: W): W
}

open class ClassWithGenerics<T, U> : InterfaceWithGenerics<T, U> {
    override fun convert(input: T): U {
        TODO("Not yet implemented")
    }

    override fun <V> convertWithFunctionGeneric(otherInput: V): V {
        TODO("Not yet implemented")
    }

    override fun <W> convertWithAnotherFunctionGeneric(anotherInput: W): W {
        TODO("Not yet implemented")
    }
}
