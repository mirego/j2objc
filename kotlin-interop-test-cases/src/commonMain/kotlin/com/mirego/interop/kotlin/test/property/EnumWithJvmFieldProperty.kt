package com.mirego.interop.kotlin.test.property

import kotlin.jvm.JvmField

enum class EnumWithJvmFieldProperty {
    VALUE,

    ;

    @JvmField
    val fieldWithCamelCaseName =
        true
}
