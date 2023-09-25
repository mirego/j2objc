@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    plugins {
        id("org.checkerframework") version "0.6.25"
    }
}

includeBuild("../annotations")
includeBuild("../translator")
