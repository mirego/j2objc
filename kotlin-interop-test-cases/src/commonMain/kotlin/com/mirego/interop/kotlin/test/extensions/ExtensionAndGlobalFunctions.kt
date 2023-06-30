package com.mirego.interop.kotlin.test.extensions

fun getString(prefix: String, message: String) = "$prefix-$message"

fun String.getWithMessage(message: String) = "$this-$message"

fun <T> List<T>.isBig() = this.count() > 100
