val checkerFrameworkVersion: String by extra

plugins {
    java
    idea
    `java-library`
    `maven-publish`
    // id("org.checkerframework")
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

    implementation("com.google.guava:guava:32.1.2-jre")

    implementation("org.checkerframework:checker:$checkerFrameworkVersion")
    annotationProcessor("org.checkerframework:checker:$checkerFrameworkVersion")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.vintage:junit-vintage-engine")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
}

//checkerFramework {
//    skipVersionCheck = true
//}

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
