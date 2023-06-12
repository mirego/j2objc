package com.google.j2objc.kompat

@Suppress("unused")
object HashMapFactory {

    fun <K, V> create(): HashMap<K, V> {
        return HashMap()
    }

    fun <K, V> create(initialCapacity: Int): HashMap<K, V> {
        return HashMap(initialCapacity)
    }

    fun <K, V> create(initialCapacity: Int, loadFactor: Float): HashMap<K, V> {
        return HashMap(initialCapacity, loadFactor)
    }

    fun <K, V> create(original: Map<out K, V>): HashMap<K, V> {
        return HashMap(original)
    }
}
