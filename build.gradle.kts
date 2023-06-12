plugins {
    java
    idea
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.named("clean") {
    dependsOn(gradle.includedBuilds.filter { !it.name.contains("annotations") && !it.name.contains("plugin") }.map { it.task(":clean") })
}

tasks.named("check") {
    dependsOn(gradle.includedBuilds.map { it.task(":check") })
}

tasks.register("publishToMavenLocal") {
    dependsOn(gradle.includedBuilds.map { it.task(":publishToMavenLocal") })
}

idea {
    module {
        excludeDirs.add(file("gradle/wrapper"))
        excludeDirs.add(file("dist"))
    }
}
