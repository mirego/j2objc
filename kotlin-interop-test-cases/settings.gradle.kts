@file:Suppress("LocalVariableName", "VariableNaming")

rootProject.name = "kotlin-test-cases"

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    val detekt_version: String by settings
    val kotlin_version: String by settings

    plugins {
        kotlin("multiplatform") version kotlin_version
        id("dev.detekt") version detekt_version
    }
}

includeBuild("../j2objc-kompat")
