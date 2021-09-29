package com.psa.sdk.service

import android.graphics.Bitmap
import kotlinx.coroutines.flow.MutableStateFlow

interface DataFlow <T>{
    var dataFlow: MutableStateFlow<T?>
    var messageFlow: MutableStateFlow<T?>
    var assetFlow: MutableStateFlow<Bitmap?>
}