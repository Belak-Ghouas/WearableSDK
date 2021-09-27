package com.psa.sdk.send

import com.google.android.gms.wearable.*
import com.psa.sdk.util.EventUri
import com.psa.sdk.models.Result

interface SenderInterface {

    fun sendMessage(data: ByteArray,onCompletedListener: ((Result<ByteArray>) -> Unit)?=null)
    fun sendData(data: ByteArray, event: EventUri, onCompletedListener: ((Result<ByteArray>)->Unit )? =null)
    fun sendAsset(data: Asset, assetName:String, path: String, onCompletedListener: ((Result<Asset>) ->Unit )? =null)
}