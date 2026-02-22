package com.mirego.interop.kotlin.test.dataclass

data class DataClassWithFieldsOfCollectionTypes(
    val collection: Collection<String>,
    val list: List<String>,
    val set: Set<String>,
    val map: Map<String, String>,
)
