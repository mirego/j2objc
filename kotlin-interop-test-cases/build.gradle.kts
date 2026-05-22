import org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile

group = "com.mirego"
version = "3.0"

val isCi = System.getenv().containsKey("CI")

repositories {
    mavenCentral()
    google()
}

plugins {
    idea
    kotlin("multiplatform")
    alias(libs.plugins.detekt)
}

kotlin {
    jvmToolchain(17)

    jvm()

    macosArm64 {
        binaries {
            framework {
                baseName = "common"
                export(project(":j2objc-kompat"))
                binaryOption("bundleId", "com.google.j2objc.kompat")
                isStatic = true
            }
        }
    }

    iosArm64()
    iosSimulatorArm64()

    tvosArm64()
    tvosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                api(project(":j2objc-kompat"))
            }
        }

        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCRefinement")
            languageSettings.optIn("kotlin.js.ExperimentalJsExport")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
    }

    compilerOptions {
        allWarningsAsErrors.set(isCi)
        extraWarnings.set(true)
        freeCompilerArgs.add("-Xallow-condition-implies-returns-contracts")
        freeCompilerArgs.add("-Xallow-contracts-on-more-functions")
        freeCompilerArgs.add("-Xallow-holdsin-contract")
        freeCompilerArgs.add("-Xallow-reified-type-in-catch")
        freeCompilerArgs.add("-Xannotation-default-target=param-property")
        freeCompilerArgs.add("-Xannotation-target-all")
        freeCompilerArgs.add("-Xconsistent-data-class-copy-visibility")
        freeCompilerArgs.add("-Xcontext-parameters")
        freeCompilerArgs.add("-Xcontext-sensitive-resolution")
        freeCompilerArgs.add("-Xdata-flow-based-exhaustiveness")
        freeCompilerArgs.add("-Xexpect-actual-classes")
        freeCompilerArgs.add("-Xmulti-dollar-interpolation")
        freeCompilerArgs.add("-Xnested-type-aliases")
        freeCompilerArgs.add("-Xnon-local-break-continue")
        freeCompilerArgs.add("-Xreturn-value-checker=full")
        freeCompilerArgs.add("-Xwhen-guards")
    }
}

dependencies {
    detektPlugins(libs.detekt.rules.ktlint.wrapper)
}

// Disable interfaces and swift name mangling
tasks.withType<KotlinNativeCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xbinary=objcExportDisableSwiftMemberNameMangling=true")
        freeCompilerArgs.add("-Xbinary=objcExportIgnoreInterfaceMethodCollisions=true")
    }
}

detekt {
    autoCorrect = !isCi
    ignoreFailures = !isCi
    buildUponDefaultConfig = true
    config.setFrom(rootProject.file("detekt-config.yml"))
    source.setFrom(fileTree("src").matching { include("*Main/**", "*Test/**") })
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
    }
}
