@file:Suppress("LocalVariableName", "VariableNaming")

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

includeBuild("../annotations")
includeBuild("../translator")
