import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

val kotlinVersion: String by extra

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

plugins {
    idea
    kotlin("multiplatform")
    `maven-publish`
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    jvmToolchain(11)

    jvm {
        compilations.all {
            kotlinOptions.allWarningsAsErrors = true
        }
    }

    macosArm64 {
        binaries {
            framework {
                baseName = "common"
                export("com.google.j2objc:j2objc-kompat:$version")
                binaryOption("bundleId", "com.google.j2objc.kompat")
                isStatic = true
            }
        }
    }

    ios()
    iosSimulatorArm64()

    val iosMain by sourceSets.getting
    val iosTest by sourceSets.getting
    val iosSimulatorArm64Main by sourceSets.getting
    val iosSimulatorArm64Test by sourceSets.getting
    iosSimulatorArm64Main.dependsOn(iosMain)
    iosSimulatorArm64Test.dependsOn(iosTest)

    tvos()
    tvosSimulatorArm64()

    val tvosMain by sourceSets.getting
    val tvosTest by sourceSets.getting
    val tvosSimulatorArm64Main by sourceSets.getting
    val tvosSimulatorArm64Test by sourceSets.getting
    tvosSimulatorArm64Main.dependsOn(tvosMain)
    tvosSimulatorArm64Test.dependsOn(tvosTest)

    sourceSets {
        named("commonMain") {
            dependencies {
                api("com.google.j2objc:j2objc-kompat:$version")
                implementation(kotlin("stdlib-common", kotlinVersion))
                implementation("com.google.j2objc:j2objc-kompat:3.0")
            }
        }

        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
    }
}
