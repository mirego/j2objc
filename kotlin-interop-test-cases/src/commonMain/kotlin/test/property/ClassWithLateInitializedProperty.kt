package com.mirego.interop.kotlin.test.property

import kotlin.js.JsName

class ClassWithLateInitializedProperty() {
    @Suppress("UNNECESSARY_LATEINIT")
    lateinit var lateInitializedProperty: String

    init {
        lateInitializedProperty = "initialized"
    }
}
