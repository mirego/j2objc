package com.mirego.interop.kotlin.test.interfaces

interface InterfaceWithGenerics<T, U> {
    fun convert(input: T): U
}
