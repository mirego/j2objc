rootProject.name = "kotlin-test-cases"

pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    val kotlinVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
    }
}

includeBuild("../j2objc-kompat")
