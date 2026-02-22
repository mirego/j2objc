@file:JvmName("KotlinTopLevelFunctionWithOverriddenJvmFilenameOVERRIDE")

package com.mirego.interop.kotlin.test.function

import kotlin.js.JsExport
import kotlin.jvm.JvmName

// Note: once in JS, the function must be accessed directly (top level) without using
// the filename as prefix.
@JsExport
@Suppress("FunctionOnlyReturningConstant")
fun topLevelFunctionInOverriddenJvmFilename(): String {
    return "topLevelFunctionInOverriddenJvmFilename"
}
