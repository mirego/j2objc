@file:Suppress("LocalVariableName", "VariableNaming", "PropertyName")

val checkerFrameworkVersion: String by extra
val kotlin_version: String by extra

plugins {
    java
    idea
    `java-library`
    kotlin("jvm")
    id("com.adarshr.test-logger")
    `maven-publish`
}

repositories {
    mavenCentral()
    google()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(11)
}

sourceSets {
    test {
        java {
            srcDir("../kotlin-native-tests/src/test/java")
            setExcludes(
                listOf(
                    "com/google/devtools/j2objc/regression/*.java",
                    "com/google/devtools/j2objc/**/*Tests.java",
                ),
            )
        }
    }
}

dependencies {
    implementation("com.google.j2objc:j2objc-annotations:3.1")
    implementation("com.google.j2objc:j2objc-kompat:3.0")
    implementation("com.google.j2objc:jre_emul:3.0")

    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.guava:guava:33.5.0-jre")
    implementation("org.bitbucket.mstrobel:procyon-compilertools:0.6.0")
    implementation("org.bitbucket.mstrobel:procyon-core:0.6.0")
    implementation("org.jspecify:jspecify:1.0.0")
    implementation("org.plumelib:plume-util:1.12.3")

    // Sync with eisop version used in Makefile
    implementation("org.checkerframework:checker:$checkerFrameworkVersion")

    //noinspection NewerVersionAvailable - 6.0.0+ require JDK 17
    implementation(platform("org.junit:junit-bom:5.14.2"))
    implementation("org.junit.vintage:junit-vintage-engine")
    implementation("org.slf4j:slf4j-nop:2.0.17")

    testImplementation("com.google.flogger:flogger:0.9")
    testImplementation("com.google.flogger:google-extensions:0.9")
    //noinspection NewerVersionAvailable - Use the same version as `jars.mk`
    testImplementation("org.hamcrest:hamcrest-all:1.3")

    // kotlin interop >>
    implementation("org.jetbrains.kotlin:kotlin-metadata-jvm:$kotlin_version")

    testImplementation("com.mirego:kotlin-test-cases:$version")
    // kotlin interop <<
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()

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
