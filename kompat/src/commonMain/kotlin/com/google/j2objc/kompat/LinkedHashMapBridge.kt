package com.google.j2objc.kompat

@Suppress("unused")
object LinkedHashMapBridge {

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

    fun <K, V> size(linkedHashMap: LinkedHashMap<K, V>): Int {
        return linkedHashMap.size
    }

    fun <K, V> isEmpty(linkedHashMap: LinkedHashMap<K, V>): Boolean {
        return linkedHashMap.isEmpty()
    }

    fun <K, V> containsKey(linkedHashMap: LinkedHashMap<K, V>, key: K): Boolean {
        return linkedHashMap.containsKey(key)
    }

    fun <K, V> containsValue(linkedHashMap: LinkedHashMap<K, V>, value: @UnsafeVariance V): Boolean {
        return linkedHashMap.containsValue(value)
    }

    fun <K, V> get(linkedHashMap: LinkedHashMap<K, V>, key: K): V? {
        return linkedHashMap[key]
    }

    fun <K, V> getOrDefault(linkedHashMap: LinkedHashMap<K, V>, key: K, defaultValue: @UnsafeVariance V): V {
        return linkedHashMap.getOrElse(key) { return defaultValue }
    }

    fun <K, V> keys(linkedHashMap: LinkedHashMap<K, V>): MutableSet<K> {
        return linkedHashMap.keys
    }

    fun <K, V> values(linkedHashMap: LinkedHashMap<K, V>): MutableCollection<V> {
        return linkedHashMap.values
    }

    fun <K, V> entries(linkedHashMap: LinkedHashMap<K, V>): MutableSet<MutableMap.MutableEntry<K, V>> {
        return linkedHashMap.entries
    }

    fun <K, V> equals(linkedHashMap: LinkedHashMap<K, V>, other: Any?): Boolean {
        return linkedHashMap == other
    }

    fun <K, V> hashCode(linkedHashMap: LinkedHashMap<K, V>): Int {
        return linkedHashMap.hashCode()
    }

    fun <K, V> put(linkedHashMap: LinkedHashMap<K, V>, key: K, value: V): V? {
        return linkedHashMap.put(key, value)
    }

    fun <K, V> putIfAbsent(linkedHashMap: LinkedHashMap<K, V>, key: K, value: V): V? {
        return linkedHashMap[key] ?: linkedHashMap.put(key, value)
    }

    fun <K, V> remove(linkedHashMap: LinkedHashMap<K, V>, key: K): V? {
        return linkedHashMap.remove(key)
    }

    fun <K, V> remove(linkedHashMap: LinkedHashMap<K, V>, key: K, value: V): Boolean {
        return if (linkedHashMap[key] == value) {
            linkedHashMap.remove(key)
            true
        } else {
            false
        }
    }

    fun <K, V> replace(linkedHashMap: LinkedHashMap<K, V>, key: K, oldValue: V, newValue: V): Boolean {
        return if (linkedHashMap[key] == oldValue) {
            linkedHashMap[key] = newValue
            true
        } else {
            false
        }
    }

    fun <K, V> replace(linkedHashMap: LinkedHashMap<K, V>, key: K, value: V): V? {
        return if (linkedHashMap[key] == value) {
            linkedHashMap.put(key, value)
        } else {
            null
        }
    }

    fun <K, V> putAll(linkedHashMap: LinkedHashMap<K, V>, from: Map<out K, V>) {
        return linkedHashMap.putAll(from)
    }

    fun <K, V> clear(linkedHashMap: LinkedHashMap<K, V>) {
        return linkedHashMap.clear()
    }
}
