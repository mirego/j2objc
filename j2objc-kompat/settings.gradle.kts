@file:Suppress("LocalVariableName", "VariableNaming")

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven(url = java.net.URI("https://oss.sonatype.org/content/repositories/snapshots"))
    }

    val detekt_version: String by settings
    val kotlin_version: String by settings
    val ksp_version: String by settings
    val mokkery_version: String by settings

    plugins {
        kotlin("multiplatform") version kotlin_version
        kotlin("native.cocoapods") version kotlin_version
        id("com.google.devtools.ksp") version ksp_version
        id("dev.detekt") version detekt_version
        id("dev.mokkery") version mokkery_version
    }
}
