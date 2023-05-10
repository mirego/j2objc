package com.google.j2objc.kompat

@Suppress("unused")
object LinkedHashSetFactory {

    fun <E> create(): LinkedHashSet<E> {
        return LinkedHashSet()
    }

    fun <E> create(initialCapacity: Int): LinkedHashSet<E> {
        return LinkedHashSet(initialCapacity)
    }

    fun <E> create(initialCapacity: Int, loadFactor: Float): LinkedHashSet<E> {
        return LinkedHashSet(initialCapacity, loadFactor)
    }

    fun <E> create(elements: Collection<E>): LinkedHashSet<E> {
        return LinkedHashSet(elements)
    }
}
