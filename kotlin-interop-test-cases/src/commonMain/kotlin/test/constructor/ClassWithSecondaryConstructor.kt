package com.mirego.interop.kotlin.test.constructor

class ClassWithSecondaryConstructor(val name: String) {
    constructor() : this("ClassWithSecondaryConstructor")
}
