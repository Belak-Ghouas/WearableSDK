package com.psa.wsdk.send

import com.google.android.gms.wearable.Asset
import com.psa.wsdk.models.Result
import com.psa.wsdk.util.EventUri

interface SenderInterface {

    /**
     * send the byte array with the Wearable CapabilityClient from/to the watch/phone
     * it used for light weight messages
     * @param data : the byteArray we want to send
     * @param onCompletedListener: the callback of the termination with the [Result] which can be successful,canceled..
     */
    fun sendMessage(data: ByteArray,onCompletedListener: ((Result<ByteArray>) -> Unit)?=null)

    /**
     * send data with the Wearable DataClient from/to the watch/phone
     * it user for heavy exchanges
     * @param data : the byteArray of data we want to send
     * @param
     */
    fun sendData(data: ByteArray, event: EventUri, onCompletedListener: ((Result<ByteArray>)->Unit )? =null)
    fun sendAsset(data: Asset, assetName:String, path: String, onCompletedListener: ((Result<Asset>) ->Unit )? =null)
}