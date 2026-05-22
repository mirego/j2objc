rootProject.name = "j2objc-kompat"

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    val tomlContent = file("../gradle/libs.versions.toml").readText()
    fun String.tomlVersion() = Regex("""^$this\s*=\s*"([^"]+)"""", RegexOption.MULTILINE).find(tomlContent)!!.groupValues[1]
    val kotlinVersion = "kotlin".tomlVersion()

    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
