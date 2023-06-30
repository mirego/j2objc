pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    plugins {
        id("org.checkerframework") version "0.6.25"
    }
}

includeBuild("../annotations")
includeBuild("../translator")
