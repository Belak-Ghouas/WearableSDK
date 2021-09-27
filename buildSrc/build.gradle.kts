plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
    maven("https://jitpack.io")
}

object PluginsVersions {

    const val GRADLE_ANDROID = "4.1.3"
    const val GRADLE_VERSIONS_MANAGER = "0.39.0"
    const val KOTLIN = "1.4.32"
    const val NAVIGATION = "2.3.5"
    const val JACOCO = "0.16.0"
    const val DOKKA = "1.4.30"
    const val KTLINT = "0.41.0"
    const val SPOTLESS = "5.12.5"
    const val DETEKT = "1.17.1"
    const val GRAPH_GENERATOR = "0.5.0"
    const val LOCO = "0.1.11"
    const val GOOGLE_SERVICES = "4.3.10"
    const val FIREBASE_CRASHLYTICS = "2.6.1"
    const val FIREBASE_PERFS = "1.4.0"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("com.google.gms:google-services:${PluginsVersions.GOOGLE_SERVICES}")
}
