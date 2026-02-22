@file:Suppress("LocalVariableName", "VariableNaming", "PropertyName")

plugins {
    java
    idea
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

    implementation("com.google.flogger:flogger:0.9")
    implementation("com.google.flogger:google-extensions:0.9")

    implementation("com.google.guava:guava:33.5.0-jre")
    implementation("com.google.protobuf:protobuf-java:3.25.8")

    //noinspection NewerVersionAvailable - 6.0.0+ require JDK 17
    testImplementation(platform("org.junit:junit-bom:5.14.2"))
    testImplementation("org.junit.vintage:junit-vintage-engine")
    testImplementation("org.slf4j:slf4j-nop:2.0.17")

    testImplementation("com.google.flogger:flogger-system-backend:0.9")
    testImplementation("com.google.truth:truth:1.4.5")
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
    }
}
