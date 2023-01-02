package com.cgnu.sdk.framework

import com.google.android.gms.wearable.Asset
import com.cgnu.sdk.models.Result
import com.cgnu.sdk.util.EventUri

interface ISender {

    /**
     * send the byte array with the Wearable CapabilityClient from/to the watch/phone
     * it used for light weight messages
     * @param data : the byteArray we want to send
     * @return  : the termination with the [Result] which can be successful,canceled ,failure..
     */
    suspend fun sendMessage(data: ByteArray):Result<ByteArray>

    /**
     * send data with the Wearable DataClient from/to the watch/phone
     * it user for heavy exchanges
     * @param data : the byteArray of data we want to send
     * @param
     */
    suspend fun sendData(data: ByteArray, event: EventUri):Result<ByteArray>


    /**
     * send asset
     */
    suspend fun sendAsset(data: Asset, assetName:String, path: String): Result<Asset>
}