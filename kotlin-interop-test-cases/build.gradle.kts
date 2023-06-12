import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnLockMismatchReport
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

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

    js(IR) {
        moduleName = "test"
        browser()
        binaries.executable()

        rootProject.plugins.withType(YarnPlugin::class.java).configureEach {
            rootProject.the<YarnRootExtension>().yarnLockMismatchReport = YarnLockMismatchReport.WARNING
            rootProject.the<YarnRootExtension>().reportNewYarnLock = false
            rootProject.the<YarnRootExtension>().yarnLockAutoReplace = false
        }

        rootProject.tasks.withType(KotlinNpmInstallTask::class.java).named("kotlinNpmInstall").configure {
            args.addAll(listOf("--network-concurrency", "1", "--mutex", "network"))
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

    tvos()
    tvosSimulatorArm64()

    sourceSets {
        named("commonMain") {
            dependencies {
                api("com.google.j2objc:j2objc-kompat:$version")
                implementation(kotlin("stdlib-common", kotlinVersion))
                implementation("com.google.j2objc:j2objc-kompat:3.0")
            }
        }

        named("jsMain") {
            dependencies {
                implementation(kotlin("stdlib-js", kotlinVersion))
            }
        }

        val iosMain by sourceSets.getting
        val iosTest by sourceSets.getting
        val iosSimulatorArm64Main by sourceSets.getting
        val iosSimulatorArm64Test by sourceSets.getting
        iosSimulatorArm64Main.dependsOn(iosMain)
        iosSimulatorArm64Test.dependsOn(iosTest)

        val tvosMain by sourceSets.getting
        val tvosTest by sourceSets.getting
        val tvosSimulatorArm64Main by sourceSets.getting
        val tvosSimulatorArm64Test by sourceSets.getting
        tvosSimulatorArm64Main.dependsOn(tvosMain)
        tvosSimulatorArm64Test.dependsOn(tvosTest)

        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
            languageSettings.optIn("kotlin.js.ExperimentalJsExport")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
    }
}
