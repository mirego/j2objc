package com.mirego.interop.kotlin.test.property

class ClassWithBackingPropertyCustomGetter {
    private val _backedProperty = "backed"

    val backedProperty: String
        get() {
            return _backedProperty.plus(" property")
        }
}
