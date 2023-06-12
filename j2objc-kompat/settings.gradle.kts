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
