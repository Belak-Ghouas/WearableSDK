package com.psa.sdk.framework

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
        event: EventUri
    ):Result<ByteArray> {
     return  senderDataSource.sendData(data,event)
    }

    override suspend fun sendAsset(
        data: Asset,
        assetName: String,
        path: String
    ) :Result<Asset>{
     return senderDataSource.sendAsset(data,assetName,path)
    }

}