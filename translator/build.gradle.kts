group = "com.google.j2objc"
version = "3.0"

plugins {
    idea
    java
    `java-library`
    kotlin("jvm")
    alias(libs.plugins.adarshr.test.logger)
}

repositories {
    mavenCentral()
    google()
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
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
    implementation(project(":j2objc-annotations"))
    implementation(project(":j2objc-jre_emul"))
    implementation(project(":j2objc-kompat"))

    implementation(libs.findbugs.jsr305)
    implementation(libs.guava)
    implementation(libs.procyon.compiler.tools)
    implementation(libs.procyon.core)
    implementation(libs.jspecify)
    implementation(libs.plumelib.util)

    // Sync with eisop version used in Makefile
    implementation(libs.checkerframework.checker)

    implementation(platform(libs.junit.bom))
    implementation(libs.junit.vintage.engine)
    runtimeOnly(libs.junit.platform.launcher)
    implementation(libs.slf4j.nop)

    testImplementation(libs.google.flogger)
    testImplementation(libs.google.flogger.extensions)
    testImplementation(libs.hamcrest.all)

    // kotlin interop >>
    implementation(libs.kotlin.metadata.jvm)

    testImplementation(project(":j2objc-kotlin-interop-test-cases"))
    // kotlin interop <<
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()

    // kotlin interop >>
    dependsOn(
        ":j2objc-kompat:jvmJar",
        ":j2objc-kompat:j2objcKotlinTypes",
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
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED")
    options.compilerArgs.add("--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED")
}

tasks.test {
    jvmArgs(
        "--add-exports=java.compiler/javax.lang.model.element=ALL-UNNAMED",
            "--add-exports=java.compiler/javax.lang.model.type=ALL-UNNAMED",
            "--add-exports=java.compiler/javax.lang.model.util=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.comp=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.main=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.processing=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
    )
}

tasks.named<Javadoc>("javadoc") {
    isFailOnError = false
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
        excludeDirs.add(file("build_result"))
    }
}
