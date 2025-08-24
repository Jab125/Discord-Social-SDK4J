plugins {
    id("java")
    id("maven-publish")
}

group = "dev.jab125"
version = "0.0.20"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:26.0.2")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType(JavaCompile::class).configureEach {
    options.release = 22
}

java {
    targetCompatibility = JavaVersion.VERSION_22
    sourceCompatibility = JavaVersion.VERSION_22
}

publishing {
    publications {
        val d = create("mavenJava", MavenPublication::class) {
            artifactId = "discord-social-sdk"
            from(components.getByName("java"))
        }

//        create("mavenJava", MavenPublication) {
//            artifactId = project.archives_base_name
//            from = components.java
//        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}