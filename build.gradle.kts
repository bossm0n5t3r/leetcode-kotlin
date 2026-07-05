plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ktfmt)
}

repositories { mavenCentral() }

group = "me.bossm0n5t3r"

version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.assertj.core)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
}

tasks.test { useJUnitPlatform() }

tasks.register<JavaExec>("runMain") {
    group = "application"
    description = "Runs src/main/kotlin/Main.kt"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("MainKt")
}

kotlin { jvmToolchain(libs.versions.jdk.get().toInt()) }

ktfmt { kotlinLangStyle() }
