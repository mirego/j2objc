package com.mirego.interop.kotlin.test.interfaces

interface InterfaceWithList<E> {
    fun convert(inputList: List<E>) : List<E>
}
