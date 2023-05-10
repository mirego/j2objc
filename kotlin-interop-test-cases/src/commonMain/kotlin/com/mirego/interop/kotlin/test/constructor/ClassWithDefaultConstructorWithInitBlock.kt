package com.mirego.interop.kotlin.test.constructor

class ClassWithDefaultConstructorWithInitBlock(var name: String) {
    init {
        name = "nameSetInInitBlock"
    }
}
