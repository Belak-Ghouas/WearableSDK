package com.psa.sdk.service

import android.graphics.Bitmap
import com.psa.sdk.models.DataExchanged
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.lang.IllegalArgumentException
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class FlowHandler<S> :DataFlow<S> {

    override var dataFlow: MutableStateFlow<S?> = MutableStateFlow(null)
    override var messageFlow: MutableStateFlow<S?> = MutableStateFlow(null)
    override var assetFlow: MutableStateFlow<Bitmap?> = MutableStateFlow(null)
var test="hi ev"



}