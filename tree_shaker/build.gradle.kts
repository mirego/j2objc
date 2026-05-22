group = "com.google.j2objc"
version = "3.0"

plugins {
    java
    idea
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
    implementation(project(":j2objc-translator"))

    implementation(libs.google.flogger)
    implementation(libs.google.flogger.extensions)

    implementation(libs.guava)
    implementation(libs.google.protobuf.java)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.vintage.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.slf4j.nop)

    testImplementation(libs.google.flogger.system.backend)
    testImplementation(libs.google.truth)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
    }
}
