import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.TestExecutable
import java.io.ByteArrayOutputStream

val kotlin_version: String by extra
val detekt_version: String by extra

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

plugins {
    idea
    kotlin("multiplatform")
    id("io.gitlab.arturbosch.detekt")
    // id("io.github.detekt.gradle.compiler-plugin")
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

    ios { compilations.configureEach { compilerOptions.configure { freeCompilerArgs.add("-Xallocator=custom") } } }
    iosSimulatorArm64 { compilations.configureEach { compilerOptions.configure { freeCompilerArgs.add("-Xallocator=custom") } } }

    val iosMain by sourceSets.getting
    val iosTest by sourceSets.getting
    val iosSimulatorArm64Main by sourceSets.getting
    val iosSimulatorArm64Test by sourceSets.getting
    iosSimulatorArm64Main.dependsOn(iosMain)
    iosSimulatorArm64Test.dependsOn(iosTest)

    tvos { compilations.configureEach { compilerOptions.configure { freeCompilerArgs.add("-Xallocator=custom") } } }
    tvosSimulatorArm64 { compilations.configureEach { compilerOptions.configure { freeCompilerArgs.add("-Xallocator=custom") } } }

    val tvosMain by sourceSets.getting
    val tvosTest by sourceSets.getting
    val tvosSimulatorArm64Main by sourceSets.getting
    val tvosSimulatorArm64Test by sourceSets.getting
    tvosSimulatorArm64Main.dependsOn(tvosMain)
    tvosSimulatorArm64Test.dependsOn(tvosTest)

    // Xcode 15 new linker is incompatible with Kotlin, tell it to use the old linker
    val isXcode15 = if (!OperatingSystem.current().isMacOsX) false else {
        val xcodeBuildOutput = ByteArrayOutputStream()
        exec { commandLine("xcrun", "xcodebuild", "-version"); standardOutput = xcodeBuildOutput; isIgnoreExitValue = true }
        xcodeBuildOutput.toString().contains("Xcode 15.")
    }
    if (isXcode15) {
        targets.withType<KotlinNativeTarget> { binaries.withType<TestExecutable> { linkerOpts += "-ld64" } }
    }

    sourceSets {
        named("commonMain") {
            dependencies {
                api("com.google.j2objc:j2objc-kompat:$version")
            }
        }

        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
            languageSettings.optIn("kotlin.js.ExperimentalJsExport")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detekt_version")
}

detekt {
    autoCorrect = true
    buildUponDefaultConfig = true
    config.setFrom("../../../detekt-config.yml")
    source.setFrom(file("src").listFiles()!!.filter { it.name.endsWith("Main") || it.name.endsWith("Test") })
}

tasks.withType<Detekt>().configureEach { jvmTarget = JavaVersion.VERSION_11.toString() }
tasks.withType<DetektCreateBaselineTask>().configureEach { jvmTarget = JavaVersion.VERSION_11.toString() }

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
    }
}
