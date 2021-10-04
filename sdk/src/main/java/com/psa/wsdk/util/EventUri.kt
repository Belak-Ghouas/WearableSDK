package com.psa.wsdk.util

import android.net.Uri

interface EventUri {
    fun getUri(): Uri
    fun getPath():String
}