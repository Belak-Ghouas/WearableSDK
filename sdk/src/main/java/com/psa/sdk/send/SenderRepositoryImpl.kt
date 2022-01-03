package com.psa.sdk.send

import com.google.android.gms.wearable.Asset
import com.psa.sdk.models.Result
import com.psa.sdk.util.EventUri

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
class SenderRepositoryImpl(private val senderDataSource: SenderDataSource):SenderRepository {


    override suspend fun sendMessage(
        data: ByteArray,
    ): Result<ByteArray> {
        return senderDataSource.sendMessage(data)
    }

    override suspend fun sendData(
        data: ByteArray,
        event: EventUri,
        onCompletedListener: ((Result<ByteArray>) -> Unit)?
    ) {
      senderDataSource.sendData(data,event,onCompletedListener)
    }

    override suspend fun sendAsset(
        data: Asset,
        assetName: String,
        path: String,
        onCompletedListener: ((Result<Asset>) -> Unit)?
    ) {
      senderDataSource.sendAsset(data,assetName,path,onCompletedListener)
    }

}