rootProject.name = "kotlin-test-cases"

pluginManagement {
    val kotlinVersion: String by settings

    plugins {
        kotlin("multiplatform") version kotlinVersion
    }
}

includeBuild("../kompat")
