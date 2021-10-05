package com.psa.sdk.util

import android.net.Uri

interface EventUri {
    fun getUri(): Uri
    fun getPath():String
}