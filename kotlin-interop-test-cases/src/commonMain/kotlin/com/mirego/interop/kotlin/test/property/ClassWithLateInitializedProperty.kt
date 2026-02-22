package com.mirego.interop.kotlin.test.property

class ClassWithLateInitializedProperty {

    @Suppress("JoinDeclarationAndAssignment", "UNNECESSARY_LATEINIT")
    lateinit var lateInitializedProperty: String

    init {
        lateInitializedProperty = "initialized"
    }
}
