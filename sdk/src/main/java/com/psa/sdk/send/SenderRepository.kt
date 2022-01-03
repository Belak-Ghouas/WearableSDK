package com.psa.sdk.send

import com.google.android.gms.wearable.Asset
import com.psa.sdk.models.Result
import com.psa.sdk.util.EventUri

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
interface SenderRepository {
    suspend fun sendMessage(data: ByteArray):Result<ByteArray>
    suspend fun sendData(data: ByteArray, event: EventUri, onCompletedListener: ((Result<ByteArray>)->Unit )? =null)
    suspend fun sendAsset(data: Asset, assetName:String, path: String, onCompletedListener: ((Result<Asset>) ->Unit )? =null)
}