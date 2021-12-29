package com.psa.sdk.send

import com.google.android.gms.wearable.Asset
import com.psa.sdk.models.Result
import com.psa.sdk.util.EventUri

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
interface SenderDataSource {

    /**
     * send the byte array with the Wearable CapabilityClient from/to the watch/phone
     * it used for light weight messages
     * @param data : the byteArray we want to send
     * @param onCompletedListener: the callback of the termination with the [Result] which can be successful,canceled..
     */
    suspend fun sendMessage(data: ByteArray,onCompletedListener: ((Result<ByteArray>) -> Unit)?=null)

    /**
     * send data with the Wearable DataClient from/to the watch/phone
     * it user for heavy exchanges
     * @param data : the byteArray of data we want to send
     * @param
     */
    suspend fun sendData(data: ByteArray, event: EventUri, onCompletedListener: ((Result<ByteArray>)->Unit )? =null)
    suspend fun sendAsset(data: Asset, assetName:String, path: String, onCompletedListener: ((Result<Asset>) ->Unit )? =null)
}