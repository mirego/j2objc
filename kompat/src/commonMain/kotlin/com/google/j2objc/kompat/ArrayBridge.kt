package com.google.j2objc.kompat

@Suppress("unused")
object ArrayBridge {

    fun <T> size(array: Array<T>): Int {
        return array.size
    }

    fun <T> get(array: Array<T>, index: Int): T {
        return array[index]
    }

    fun <T> set(array: Array<T>, index: Int, value: T) {
        array[index] = value
    }

    fun <T> iterator(array: Array<T>): ConcreteIterator<T> {
        return ConcreteIterator(array.iterator())
    }
}
