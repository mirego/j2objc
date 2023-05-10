package com.google.j2objc.kompat

import kotlinx.cinterop.addressOf
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.create
import platform.posix.memcpy

@Suppress("unused")
object ByteArrayBridge {

    fun nsDataFrom(byteArray: ByteArray): NSData = memScoped {
        NSData.create(
            bytes = allocArrayOf(byteArray),
            length = byteArray.size.toULong()
        )
    }

    fun byteArrayFrom(nsData: NSData): ByteArray = ByteArray(
        nsData.length.toInt()
    ).apply {
        usePinned {
            memcpy(it.addressOf(0), nsData.bytes, nsData.length)
        }
    }
}
