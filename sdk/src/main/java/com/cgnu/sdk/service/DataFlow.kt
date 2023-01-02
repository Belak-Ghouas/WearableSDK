package com.cgnu.sdk.service

import android.graphics.Bitmap
import kotlinx.coroutines.flow.MutableStateFlow

interface DataFlow <T>{
    val dataFlow: MutableStateFlow<T?>
    val messageFlow: MutableStateFlow<T?>
    val assetFlow: MutableStateFlow<Bitmap?>
}