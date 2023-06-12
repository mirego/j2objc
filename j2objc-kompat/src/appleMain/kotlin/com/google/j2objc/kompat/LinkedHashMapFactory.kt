package com.google.j2objc.kompat

@Suppress("unused")
object LinkedHashMapFactory {

    fun <K, V> create(): LinkedHashMap<K, V> {
        return LinkedHashMap()
    }

    fun <K, V> create(initialCapacity: Int): LinkedHashMap<K, V> {
        return LinkedHashMap(initialCapacity)
    }

    fun <K, V> create(initialCapacity: Int, loadFactor: Float): LinkedHashMap<K, V> {
        return LinkedHashMap(initialCapacity, loadFactor)
    }

    fun <K, V> create(original: Map<out K, V>): LinkedHashMap<K, V> {
        return LinkedHashMap(original)
    }
}
