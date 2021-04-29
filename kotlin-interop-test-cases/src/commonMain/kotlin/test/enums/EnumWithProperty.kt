package com.mirego.interop.kotlin.test.enums

enum class EnumWithProperty(val content: String) {
    ENUMVALUE1("ENUMVALUE1_TEST") {
        override fun testFun(): String = "ENUMVALUE1_TESTFUN"
    },
    ENUMVALUE2("ENUMVALUE2_TEST") {
        override fun testFun(): String = "ENUMVALUE2_TESTFUN"
    };

    abstract fun testFun(): String
}
