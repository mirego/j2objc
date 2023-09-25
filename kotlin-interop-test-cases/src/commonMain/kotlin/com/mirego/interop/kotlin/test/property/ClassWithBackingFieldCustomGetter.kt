package com.mirego.interop.kotlin.test.property

class ClassWithBackingFieldCustomGetter {
    val backedField = "backed"
        get() {
            return field.plus(" field")
        }
}
