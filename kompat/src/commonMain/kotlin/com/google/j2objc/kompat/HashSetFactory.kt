package com.google.j2objc.kompat

@Suppress("unused")
object HashSetFactory {

    fun <E> create(): HashSet<E> {
        return HashSet()
    }

    fun <E> create(initialCapacity: Int): HashSet<E> {
        return HashSet(initialCapacity)
    }

    fun <E> create(initialCapacity: Int, loadFactor: Float): HashSet<E> {
        return HashSet(initialCapacity, loadFactor)
    }

    fun <E> create(elements: Collection<E>): HashSet<E> {
        return HashSet(elements)
    }
}
