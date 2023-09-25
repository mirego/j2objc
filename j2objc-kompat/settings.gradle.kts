@file:Suppress("UnstableApiUsage")

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
        kotlin("native.cocoapods") version kotlin_version
        id("io.gitlab.arturbosch.detekt") version detekt_version
        id("io.github.detekt.gradle.compiler-plugin") version detekt_version
    }
}
