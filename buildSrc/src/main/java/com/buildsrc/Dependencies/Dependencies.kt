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

    const val GSON="com.google.code.gson:gson:${BuildDependenciesVersions.GSON}"
    const val WEARABLE_GOOGLE_SERVICES="com.google.android.gms:play-services-wearable:${BuildDependenciesVersions.WEARABLE_GOOGLE_SERVICES}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"
    const val KOTLIN_REFLECT="org.jetbrains.kotlin:kotlin-reflect:${BuildDependenciesVersions.KOTLIN}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${BuildDependenciesVersions.MATERIAL}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependenciesVersions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependenciesVersions.COROUTINES}"
    const val ROOM = "androidx.room:room-runtime:${BuildDependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${BuildDependenciesVersions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM}"

    const val RECYCLE_VIEW = "androidx.recyclerview:recyclerview:${BuildDependenciesVersions.RECYCLE_VIEW}"
    const val RECYCLE_VIEW_SELECTION =
        "androidx.recyclerview:recyclerview-selection:${BuildDependenciesVersions.RECYCLE_VIEW_SELECTION}"
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${BuildDependenciesVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${BuildDependenciesVersions.NAVIGATION}"

    const val LIFECYCLE_SERVICE = "androidx.lifecycle:lifecycle-service:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_PROCESS = "androidx.lifecycle:lifecycle-process:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependenciesVersions.LIFECYCLE}"
    const val LIFECYCLE_SAVED_STATE =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${BuildDependenciesVersions.LIFECYCLE}"

    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${BuildDependenciesVersions.FRAGMENT_KTX}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAIN_LAYOUT}"
    const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout" +
            ":${BuildDependenciesVersions.SWIPE_REFRESH_LAYOUT}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${BuildDependenciesVersions.PAGING}"
    const val KOIN = "org.koin:koin-android:${BuildDependenciesVersions.KOIN}"
    const val KOIN_SCOPE = "org.koin:koin-androidx-scope:${BuildDependenciesVersions.KOIN}"
    const val KOIN_FRAGMENT = "org.koin:koin-androidx-fragment:${BuildDependenciesVersions.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${BuildDependenciesVersions.KOIN}"
    const val KOIN_EXT = "org.koin:koin-androidx-ext:${BuildDependenciesVersions.KOIN}"

    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependenciesVersions.RETROFIT}"
    const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${BuildDependenciesVersions.RETROFIT}"
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:${BuildDependenciesVersions.LOGGING}"
    const val MOSHI = "com.squareup.moshi:moshi:${BuildDependenciesVersions.MOSHI}"
    const val MOSHI_CODE_GEN = "com.squareup.moshi:moshi-kotlin-codegen:${BuildDependenciesVersions.MOSHI}"
    const val COIL = "io.coil-kt:coil:${BuildDependenciesVersions.COIL}"
    const val PLAY_CORE = "com.google.android.play:core:${BuildDependenciesVersions.PLAY_CORE}"
    const val ANDROID_DESUGAR = "com.android.tools:desugar_jdk_libs:${BuildDependenciesVersions.ANDROID_DESUGAR}"

    const val PIMS = "com.inetpsa.mmx:pims-UI:${BuildDependenciesVersions.PIMS}"

    const val MP_ANDROID_CHART = "com.github.PhilJay:MPAndroidChart:${BuildDependenciesVersions.MP_ANDROID_CHART}"

    const val ANDROID_MAPS = "com.google.android.gms:play-services-maps:${BuildDependenciesVersions.ANDROID_MAPS}"
    const val ANDROID_MAPS_KTX = "com.google.maps.android:maps-ktx:${BuildDependenciesVersions.ANDROID_MAPS_KTX}"
    const val ANDROID_MAPS_UTILS_KTX =
        "com.google.maps.android:maps-utils-ktx:${BuildDependenciesVersions.ANDROID_MAPS_UTILS_KTX}"

    const val INSTANT_APP = "com.google.android.gms:play-services-instantapps:${BuildDependenciesVersions.INSTANT_APP}"

    const val WORKER = "androidx.work:work-runtime-ktx:${BuildDependenciesVersions.WORKER}"

    const val FIREBASE_PLATFORM = "com.google.firebase:firebase-bom:${BuildDependenciesVersions.FIREBASE}"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
    const val FIREBASE_PERFS = "com.google.firebase:firebase-perf-ktx"

    const val GOOGLE_PLAY_SERVICES_LOCATION =
        "com.google.android.gms:play-services-location:${BuildDependenciesVersions.ANDROID_LOCATION}"

    const val GOOGLE_PLACES = "com.google.android.libraries.places:places:${BuildDependenciesVersions.GOOGLE_PLACES}"

    const val G_PLAY_SERVICE_AUTH =
        "com.google.android.gms:play-services-auth:${BuildDependenciesVersions.ANDROID_AUTH}"
    const val G_PLAY_SERVICE_AUTH_API_PHONE =
        "com.google.android.gms:play-services-auth-api-phone:${BuildDependenciesVersions.ANDROID_AUTH_API_PHONE}"
}
