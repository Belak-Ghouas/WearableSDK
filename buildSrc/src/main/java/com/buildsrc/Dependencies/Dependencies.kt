/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.buildsrc.Dependencies

/**
 * Project dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */

object Dependencies {

    const val GSON = "com.google.code.gson:gson:${BuildDependenciesVersions.GSON}"
    const val WEARABLE_GOOGLE_SERVICES =
        "com.google.android.gms:play-services-wearable:${BuildDependenciesVersions.WEARABLE_GOOGLE_SERVICES}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val KOTLIN_REFLECT =
        "org.jetbrains.kotlin:kotlin-reflect:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val MATERIAL =
        "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"


    const val LIFECYCLE_SERVICE =
        "androidx.lifecycle:lifecycle-service:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_COMMON =
        "androidx.lifecycle:lifecycle-common-java8:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_PROCESS =
        "androidx.lifecycle:lifecycle-process:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_SAVED_STATE =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${BuildDependenciesVersions.LIFECYCLE}"

    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAIN_LAYOUT}"

    const val KOIN = "org.koin:koin-android:${BuildDependenciesVersions.KOIN}"
    const val KOIN_SCOPE = "org.koin:koin-androidx-scope:${BuildDependenciesVersions.KOIN}"
    const val KOIN_FRAGMENT = "org.koin:koin-androidx-fragment:${BuildDependenciesVersions.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${BuildDependenciesVersions.KOIN}"
    const val KOIN_EXT = "org.koin:koin-androidx-ext:${BuildDependenciesVersions.KOIN}"

    const val LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.LOGGING}"
    const val PLAY_CORE = "com.google.android.play:core:${BuildDependenciesVersions.PLAY_CORE}"


}
