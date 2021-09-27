import com.buildsrc.Dependencies.Dependencies

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    kotlin("android")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION )
    dexOptions {
        javaMaxHeapSize = "4G"
    }

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
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.LOGGING)
    implementation(Dependencies.PLAY_CORE)
    implementation(Dependencies.KOIN)
    implementation(Dependencies.KOIN_FRAGMENT)
    implementation(Dependencies.KOIN_SCOPE)
    implementation(Dependencies.KOIN_VIEWMODEL)
    implementation(Dependencies.KOIN_EXT)

    implementation(Dependencies.LIFECYCLE_SERVICE)
    implementation(Dependencies.LIFECYCLE_COMMON)
    implementation(Dependencies.LIFECYCLE_PROCESS)
    implementation(Dependencies.LIFECYCLE_LIVEDATA)
    implementation(Dependencies.LIFECYCLE_SAVED_STATE)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation (Dependencies.WEARABLE_GOOGLE_SERVICES)
    implementation (Dependencies.GSON)

}