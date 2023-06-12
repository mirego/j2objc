plugins {
    java
    idea
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))

    withSourcesJar()
}

dependencies {
    implementation("com.google.j2objc:j2objc-annotations:3.0")
    implementation("com.google.j2objc:translator:3.0")

    implementation("com.google.flogger:flogger:0.7.4")
    implementation("com.google.flogger:google-extensions:0.7.4")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.google.protobuf:protobuf-java:3.22.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0-M1"))
    testImplementation("org.junit.vintage:junit-vintage-engine")

    testImplementation("com.google.flogger:flogger-system-backend:0.7.4")
    testImplementation("com.google.truth:truth:1.1.3")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
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
