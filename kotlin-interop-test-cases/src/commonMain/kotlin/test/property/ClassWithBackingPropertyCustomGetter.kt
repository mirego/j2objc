package com.mirego.interop.kotlin.test.property

import kotlin.js.JsName

class ClassWithBackingPropertyCustomGetter() {
    private val _backedProperty = "backed"

    val backedProperty: String
        get() {
            return _backedProperty.plus(" property")
        }
}
