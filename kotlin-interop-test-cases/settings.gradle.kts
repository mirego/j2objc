@file:Suppress("UnstableApiUsage")

rootProject.name = "kotlin-test-cases"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    val kotlin_version: String by settings
    val detekt_version: String by settings

    plugins {
        kotlin("multiplatform") version kotlin_version
        id("io.gitlab.arturbosch.detekt") version detekt_version
        id("io.github.detekt.gradle.compiler-plugin") version detekt_version
    }
}

includeBuild("../j2objc-kompat")
