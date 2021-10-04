package com.psa.sdk.service

import android.graphics.Bitmap
import kotlinx.coroutines.flow.MutableStateFlow

class FlowHandler<T>:DataFlow<T> {
    override var dataFlow: MutableStateFlow<T?> = MutableStateFlow(null)
    override var messageFlow: MutableStateFlow<T?> = MutableStateFlow(null)
    override var assetFlow: MutableStateFlow<Bitmap?> = MutableStateFlow(null)
}