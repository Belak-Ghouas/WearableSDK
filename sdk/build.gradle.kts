import com.buildsrc.Dependencies.Dependencies
import java.util.Properties
import java.io.FileInputStream

plugins{
    id(BuildPlugins.ANDROID_LIBRARY)
    kotlin("android")
    kotlin("android.extensions")
    id(BuildPlugins.MAVEN_PUBLISH)
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
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME
        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER

    }

    val githubProperties = Properties()
    githubProperties.load(FileInputStream(rootProject.file("github.properties")))
    publishing {
        publications {
            create<MavenPublication>("psa") {
                run {
                    groupId = BuildAndroidConfig.APPLICATION_ID
                    artifactId = "sdk"
                    version = BuildAndroidConfig.VERSION_NAME
                    artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
                }
            }
        }

        repositories {
            maven {
                name = "WearableSDK"
                /** Configure path of your package repository on Github
                 *  Replace GITHUB_USERID with your/organisation Github userID and REPOSITORY with the repository name on GitHub
                 */
                url = uri("https://maven.pkg.github.com/ghouasabdelhak/WearableSDK") // Github Package
                credentials {
                    //Fetch these details from the properties file or from Environment variables
                    username = githubProperties["gpr.usr"] as String? ?: System.getenv("GPR_USER")
                    password = githubProperties["gpr.key"] as String? ?: System.getenv("GPR_API_KEY")
                }
            }
        }
    }

}

dependencies {
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.CORE_KTX)
    implementation (Dependencies.WEARABLE_GOOGLE_SERVICES)
    implementation (Dependencies.GSON)
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.KOTLIN_REFLECT)
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}