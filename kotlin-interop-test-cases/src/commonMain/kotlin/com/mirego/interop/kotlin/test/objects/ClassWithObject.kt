package com.mirego.interop.kotlin.test.objects

class ClassWithObject {
    object Named {
        @Suppress("MayBeConst")
        val objectString: String =
            "objectString"
    }
}
