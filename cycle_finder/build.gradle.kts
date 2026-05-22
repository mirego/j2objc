group = "com.google.j2objc"
version = "3.0"

plugins {
    idea
    java
    `java-library`
}

repositories {
    mavenCentral()
    google()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

dependencies {
    implementation(project(":j2objc-annotations"))
    implementation(project(":j2objc-translator")

    implementation(libs.guava)

    // Sync with eisop version used in Makefile
    implementation(libs.checkerframework.checker)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.vintage.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.slf4j.nop)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
        excludeDirs.add(file("build_result"))
    }
}
