package com.google.j2objc.kompat

@Suppress("unused")
object ArrayFactory {

    inline fun <reified T> create(size: Int, noinline init: (Int) -> T): Array<T> {
        return Array(size, init)
    }
}
