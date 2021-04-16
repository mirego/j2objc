package com.mirego.interop.kotlin.test.property

import kotlin.js.JsName

class ClassWithBackingPropertyCustomSetter() {
    private var _backedProperty = "defaultBackedProperty"

    @get:JsName("getBackedProperty")
    @set:JsName("setBackedProperty")
    public var backedProperty: String
        get() {
            return _backedProperty
        }
        set(value) {
            _backedProperty = value
        }
}
