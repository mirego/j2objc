package com.mirego.interop.kotlin.test.property

class ClassWithLateInitializedProperty {

    @Suppress("Warnings", "JoinDeclarationAndAssignment")
    lateinit var lateInitializedProperty: String

    init {
        lateInitializedProperty = "initialized"
    }
}
