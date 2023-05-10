plugins {
    java
    idea
    `java-library`
    `maven-publish`
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))

    withSourcesJar()
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

        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
