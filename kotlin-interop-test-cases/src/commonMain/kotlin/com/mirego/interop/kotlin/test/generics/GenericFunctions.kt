package com.mirego.interop.kotlin.test.generics

object GenericFunctions {
    @Suppress("UseRequire")
    fun <T> validateNotNull(target: T?): T {
        if (target == null) {
            throw IllegalArgumentException("Target cannot be null")
        }
        return target
    }
}
