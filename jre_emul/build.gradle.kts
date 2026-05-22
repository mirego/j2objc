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

@Suppress("SpellCheckingInspection")
sourceSets {
    main {
        java.setSrcDirs(
            listOf(
                "Classes",
                "android/frameworks/base/core/java",
                "android/platform/external/icu/android_icu4j/libcore_bridge/src/java",
                "android/platform/external/icu/android_icu4j/src/main/java",
                "android/platform/external/okhttp/okio/okio/src/main/java",
                "android/platform/libcore/dalvik/src/main/java",
                "android/platform/libcore/json/src/main/java",
                "android/platform/libcore/luni/src/main/java",
                "android/platform/libcore/luni/src/objc/java",
                "android/platform/libcore/ojluni/src/lambda/java",
                "android/platform/libcore/ojluni/src/main/java",
                "android/platform/libcore/xml/src/main/java",
                "android/tools/platform-compat/java",
                "apache_harmony/classlib/modules/beans/src/main/java",
                "openjdk/src/macosx/classes",
                "openjdk/src/share/classes",
                "stub_classes/java",
            ).map { file(it) },
        )
    }

    /* test {
        java.setSrcDirs(
            listOf(
                "android/frameworks/base/core/tests/coretests/src",
                "android/frameworks/base/tests-runner/src",
                "android/platform/external/icu/android_icu4j/src/main/tests",
                "android/platform/external/mockwebserver/src/main/java",
                "android/platform/external/okhttp/okio/okio/src/test/java",
                "android/platform/libcore/dalvik/src/test/java",
                "android/platform/libcore/harmony-tests/src/test/java",
                "android/platform/libcore/json/src/test/java",
                "android/platform/libcore/jsr166-tests/src/test/java",
                "android/platform/libcore/luni/src/test/java",
                "android/platform/libcore/ojluni/src",
                "android/platform/libcore/ojluni/src/test/java/time",
                "android/platform/libcore/support/src/test/java",
                "apache_commons_lang/src/test/java",
                "apache_harmony/classlib/modules/beans/src/test/java",
                "apache_harmony/classlib/modules/beans/src/test/support/java",
                "misc_tests",
            ).map { file(it) },
        )
    } */
}

dependencies {
    implementation(project(":j2objc-annotations"))

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.vintage.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.slf4j.nop)

    testImplementation(libs.junit.dataprovider)
    testImplementation(libs.hamcrest.all)
    testImplementation(libs.junit.params)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()
}

tasks.named<JavaCompile>("compileJava") {
    val sources = (sourceSets.named("main").get().java.srcDirs).joinToString(":") { it.path }
    options.compilerArgs.add("--patch-module=java.base=$sources")
    options.compilerArgs.add("--add-reads=java.base=ALL-UNNAMED")
}

tasks.named<JavaCompile>("compileTestJava") {
    val sources = (sourceSets.named("test").get().java.srcDirs + layout.buildDirectory.file("classes/java").get().asFile).joinToString(":") { it.path }
    options.compilerArgs.add("--patch-module=java.base=$sources")
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
