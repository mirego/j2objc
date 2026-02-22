@file:Suppress("LocalVariableName", "VariableNaming", "PropertyName")

val checkerFrameworkVersion: String by extra

plugins {
    idea
    java
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(11)
}

dependencies {
    implementation("com.google.j2objc:j2objc-annotations:3.1")
    implementation("com.google.j2objc:translator:3.0")

    implementation("com.google.guava:guava:33.5.0-jre")

    // Sync with eisop version used in Makefile
    implementation("org.checkerframework:checker:$checkerFrameworkVersion")

    //noinspection NewerVersionAvailable - 6.0.0+ require JDK 17
    testImplementation(platform("org.junit:junit-bom:5.14.2"))
    testImplementation("org.junit.vintage:junit-vintage-engine")
    testImplementation("org.slf4j:slf4j-nop:2.0.17")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()
}

publishing {
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
        }
    }
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
        excludeDirs.add(file("build_result"))
    }
}
