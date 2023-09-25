@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    val kotlin_version: String by settings

    plugins {
        kotlin("jvm") version kotlin_version
        id("org.checkerframework") version "0.6.25"
        id("com.adarshr.test-logger") version "3.2.0"
    }
}

includeBuild("../annotations")
includeBuild("../jre_emul")

// kotlin interop >>
includeBuild("../j2objc-kompat")
includeBuild("../kotlin-interop-test-cases")
// kotlin interop <<
