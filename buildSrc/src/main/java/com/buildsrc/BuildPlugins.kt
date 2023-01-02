

/**
 * Configuration of all gradle build plugins
 */
object BuildPlugins {

    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"
    const val MAVEN_PUBLISH="maven-publish"

    const val JACOCO = "com.vanniktech.android.junit.jacoco"
    const val GRAPH_GENERATOR = "com.vanniktech.dependency.graph.generator"

    const val GOOGLE_SERVICES = "com.google.gms.google-services"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase.crashlytics"
    const val FIREBASE_PERFS = "com.google.firebase.firebase-perf"

    const val DETEKT = "plugins.detekt"
    const val DOKKA = "plugins.dokka"
    const val GIT_HOOKS = "plugins.git-hooks"
    const val KTLINT = "plugins.ktlint"
    const val SPOTLESS = "plugins.spotless"
}
