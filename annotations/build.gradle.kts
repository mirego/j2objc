group = "com.google.j2objc"
version = "3.0"

plugins {
    java
    idea
    `java-library`
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
        excludeDirs.add(file("build_result"))
    }
}
