package com.mirego.interop.kotlin.test.function

import kotlin.native.ObjCName

class ClassWithFunctionsReceivingCollectionTypes {
    fun receive(map: Map<String, String>) {
        println("Map received: $map")
    }

    fun receive(list: List<String>) {
        println("List received: $list")
    }

    fun receive(set: Set<String>) {
        println("Set received: $set")
    }

    fun receive(collection: Collection<String>) {
        println("Collection received: $collection")
    }
}
