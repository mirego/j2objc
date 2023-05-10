package com.google.j2objc.kompat

@Suppress("unused")
object HashMapBridge {

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

    fun <K, V> size(hashMap: HashMap<K, V>): Int {
        return hashMap.size
    }

    fun <K, V> isEmpty(hashMap: HashMap<K, V>): Boolean {
        return hashMap.isEmpty()
    }

    fun <K, V> containsKey(hashMap: HashMap<K, V>, key: K): Boolean {
        return hashMap.containsKey(key)
    }

    fun <K, V> containsValue(hashMap: HashMap<K, V>, value: @UnsafeVariance V): Boolean {
        return hashMap.containsValue(value)
    }

    fun <K, V> get(hashMap: HashMap<K, V>, key: K): V? {
        return hashMap[key]
    }

    fun <K, V> getOrDefault(hashMap: HashMap<K, V>, key: K, defaultValue: @UnsafeVariance V): V {
        return hashMap.getOrElse(key) { return defaultValue }
    }

    fun <K, V> keys(hashMap: HashMap<K, V>): MutableSet<K> {
        return hashMap.keys
    }

    fun <K, V> values(hashMap: HashMap<K, V>): /*Concrete*/MutableCollection<V> {
        return ArrayList(hashMap.values)
        // return ConcreteMutableCollection(hashMap.values)
    }

    fun <K, V> entries(hashMap: HashMap<K, V>): MutableSet<ConcreteMutableEntry<K, V>> {
        return HashSet(hashMap.entries.map { ConcreteMutableEntry(it) })
    }

    fun <K, V> equals(hashMap: HashMap<K, V>, other: Any?): Boolean {
        return hashMap == other
    }

    fun <K, V> hashCode(hashMap: HashMap<K, V>): Int {
        return hashMap.hashCode()
    }

    fun <K, V> put(hashMap: HashMap<K, V>, key: K, value: V): V? {
        return hashMap.put(key, value)
    }

    fun <K, V> putIfAbsent(hashMap: HashMap<K, V>, key: K, value: V): V? {
        return hashMap[key] ?: hashMap.put(key, value)
    }

    fun <K, V> remove(hashMap: HashMap<K, V>, key: K): V? {
        return hashMap.remove(key)
    }

    fun <K, V> remove(hashMap: HashMap<K, V>, key: K, value: V): Boolean {
        return if (hashMap[key] == value) {
            hashMap.remove(key)
            true
        } else {
            false
        }
    }

    fun <K, V> replace(hashMap: HashMap<K, V>, key: K, oldValue: V, newValue: V): Boolean {
        return if (hashMap[key] == oldValue) {
            hashMap[key] = newValue
            true
        } else {
            false
        }
    }

    fun <K, V> replace(hashMap: HashMap<K, V>, key: K, value: V): V? {
        return if (hashMap[key] == value) {
            hashMap.put(key, value)
        } else {
            null
        }
    }

    fun <K, V> putAll(hashMap: HashMap<K, V>, from: Map<out K, V>) {
        return hashMap.putAll(from)
    }

    fun <K, V> clear(hashMap: HashMap<K, V>) {
        return hashMap.clear()
    }
}

class ConcreteMutableEntry<K, V>(delegate: MutableMap.MutableEntry<K, V>) : MutableMap.MutableEntry<K, V> by delegate
