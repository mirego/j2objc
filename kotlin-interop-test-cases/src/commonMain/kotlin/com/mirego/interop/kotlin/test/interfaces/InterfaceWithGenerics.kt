package com.mirego.interop.kotlin.test.interfaces

interface InterfaceWithGenerics<T, U> {
    fun convert(input: T): U

    fun <V> convertWithFunctionGeneric(otherInput: V): V

    fun <W> convertWithAnotherFunctionGeneric(anotherInput: W): W
}
