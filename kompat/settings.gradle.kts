rootProject.name = "j2objc-kompat"

pluginManagement {
    val kotlinVersion: String by settings

    repositories {
        mavenCentral()
        google()
    }

    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("native.cocoapods") version kotlinVersion
    }
}
