pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    val kotlinVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("native.cocoapods") version kotlinVersion
    }
}
