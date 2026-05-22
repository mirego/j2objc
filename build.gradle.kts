group = "com.google.j2objc"
version = "3.0"

plugins {
    idea
    java
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

val subprojects = listOf(
    ":j2objc-annotations",
    ":j2objc-kompat",
    ":j2objc-jre_emul",
    ":j2objc-kotlin-interop-test-cases",
    ":j2objc-translator",
)

listOf("check", "clean").forEach { taskName ->
    tasks.named(taskName) {
        dependsOn(subprojects.map { "$it:$taskName" })
    }
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
        excludeDirs.add(file("dist"))
    }
}
