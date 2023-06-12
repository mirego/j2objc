val checkerFrameworkVersion: String by extra

plugins {
    java
    idea
    `java-library`
    `maven-publish`
    kotlin("jvm")
    id("org.checkerframework")
    id("com.adarshr.test-logger") version "3.2.0"
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11

    withSourcesJar()
}

sourceSets {
    test {
        java {
            srcDir("../kotlin-native-tests/src/test/java")
            setExcludes(listOf(
                "com/google/devtools/j2objc/regression/*.java",
                "com/google/devtools/j2objc/**/*Tests.java",
            ))
        }
    }
}

dependencies {
    implementation("com.google.j2objc:j2objc-annotations:3.0")
    implementation("com.google.j2objc:j2objc-kompat:3.0")
    implementation("com.google.j2objc:jre_emul:3.0")

    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.bitbucket.mstrobel:procyon-compilertools:0.6.0")
    implementation("org.bitbucket.mstrobel:procyon-core:0.6.0")
    implementation("org.jspecify:jspecify:0.3.0")
    implementation("org.plumelib:plume-util:1.6.5")

    implementation("org.checkerframework:checker:$checkerFrameworkVersion")
    annotationProcessor("org.checkerframework:checker:$checkerFrameworkVersion")

    implementation(platform("org.junit:junit-bom:5.10.0-M1"))
    implementation("org.junit.vintage:junit-vintage-engine")

    testImplementation("com.google.flogger:flogger:0.7.4")
    testImplementation("com.google.flogger:google-extensions:0.7.4")
    testImplementation("org.hamcrest:hamcrest:2.2")

    // kotlin interop >>
    implementation("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.6.0")
    implementation("org.jetbrains:annotations:24.0.1")
    implementation(kotlin("stdlib", "1.8.21"))

    testImplementation("com.mirego:kotlin-test-cases:$version")
    // kotlin interop <<
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1

    // kotlin interop >>
    dependsOn(
        gradle.includedBuild("j2objc-kompat").task(":jvmJar"),
        gradle.includedBuild("j2objc-kompat").task(":j2objcKotlinTypes"),
    )
    // kotlin interop <<
}

testlogger {
    showPassed = false
}

tasks.named<JavaCompile>("compileJava") {
    options.compilerArgs.add("--add-exports=java.compiler/javax.lang.model.element=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=java.compiler/javax.lang.model.type=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=java.compiler/javax.lang.model.util=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED")
}

checkerFramework {
    skipVersionCheck = true
}

tasks.named<Javadoc>("javadoc") {
    isFailOnError = false
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
