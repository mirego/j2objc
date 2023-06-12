package com.google.j2objc.kompat

@Suppress("unused")
object ArrayListFactory {

    fun <E> create(): ArrayList<E> {
        return ArrayList()
    }

    fun <E> create(initialCapacity: Int): ArrayList<E> {
        return ArrayList(initialCapacity)
    }

    fun <E> create(elements: Collection<E>): ArrayList<E> {
        return ArrayList(elements)
    }
}
