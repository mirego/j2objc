package com.mirego.interop.kotlin.test.property

import kotlin.js.JsName

class ClassWithBackingFieldCustomGetter() {
    val backedField = "backed"
        get() {
            return field.plus(" field")
        }
}
