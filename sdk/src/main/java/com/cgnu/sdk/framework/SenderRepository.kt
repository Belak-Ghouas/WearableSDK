package com.cgnu.sdk.framework

import com.google.android.gms.wearable.Asset
import com.cgnu.sdk.models.Result
import com.cgnu.sdk.util.EventUri

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
interface SenderRepository {

    suspend fun sendMessage(data: ByteArray):Result<ByteArray>

    suspend fun sendData(data: ByteArray, event: EventUri):Result<ByteArray>

    suspend fun sendAsset(data: Asset, assetName:String, path: String): Result<Asset>
}