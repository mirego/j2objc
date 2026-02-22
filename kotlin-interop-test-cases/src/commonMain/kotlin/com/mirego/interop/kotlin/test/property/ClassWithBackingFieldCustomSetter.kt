package com.mirego.interop.kotlin.test.property

class ClassWithBackingFieldCustomSetter {
    var backedField = "defaultBackedField"
        set(value) {
            field = "$value field"
        }
}
