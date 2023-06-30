pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    val kotlinVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        id("org.checkerframework") version "0.6.25"
    }
}

includeBuild("../annotations")
includeBuild("../jre_emul")

// kotlin interop >>
includeBuild("../j2objc-kompat")
includeBuild("../kotlin-interop-test-cases")
// kotlin interop <<
