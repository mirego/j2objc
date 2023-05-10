package com.mirego.interop.kotlin.test.function

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
}
