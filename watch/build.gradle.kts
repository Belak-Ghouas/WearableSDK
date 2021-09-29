import com.buildsrc.Dependencies.Dependencies

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    kotlin("android")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION )


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }


    defaultConfig {
        setApplicationId(BuildAndroidConfig.APPLICATION_ID)
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME
        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER

    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true
    }

}

dependencies {
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(project(":sdk"))
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    implementation(Dependencies.CORE_KTX)
    implementation (Dependencies.WEARABLE_GOOGLE_SERVICES)
    implementation (Dependencies.GSON)
    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.percentlayout:percentlayout:1.0.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.wear:wear:1.1.0")

}
