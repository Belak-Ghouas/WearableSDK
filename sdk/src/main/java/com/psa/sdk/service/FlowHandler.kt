package com.psa.sdk.service

import android.graphics.Bitmap
import kotlinx.coroutines.flow.MutableStateFlow

class FlowHandler<T> {
    var dataFlow: MutableStateFlow<T?> = MutableStateFlow(null)
    var messageFlow: MutableStateFlow<T?> = MutableStateFlow(null)
    var assetFlow: MutableStateFlow<Bitmap?> = MutableStateFlow(null)
}