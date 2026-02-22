@file:Suppress("LocalVariableName", "VariableNaming")

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    val kotlin_version: String by settings

    plugins {
        kotlin("jvm") version kotlin_version
        id("com.adarshr.test-logger") version "4.0.0"
    }
}

includeBuild("../annotations")
includeBuild("../jre_emul")

// kotlin interop >>
includeBuild("../j2objc-kompat")
includeBuild("../kotlin-interop-test-cases")
// kotlin interop <<
