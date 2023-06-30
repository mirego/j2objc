package com.mirego.interop.kotlin.test.enums

import kotlin.jvm.JvmStatic

enum class EnumWithStaticProperty {
    ENUMVALUE1(),
    ENUM_VALUE2(),
    ENUM_VALUE_3(),

    ;

    companion object {
        @JvmStatic
        val prop = "test"
    }
}
