package com.mirego.interop.kotlin.test.property

import kotlin.js.JsName

class ClassWithBackingFieldCustomSetter() {
    var backedField = "defaultBackedField"
        set(value) {
            field = value.plus(" field")
        }
}