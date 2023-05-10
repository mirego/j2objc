package com.mirego.interop.kotlin.test.constructor

class ClassWithDefaultConstructorWithMultipleInitBlocks(var name: String) {
    init {
        name = "nameSetInFirstInitBlock"
    }

    val secondProperty = "secondProperty"

    init {
        name = "nameSetInSecondInitBlock"
    }
}
