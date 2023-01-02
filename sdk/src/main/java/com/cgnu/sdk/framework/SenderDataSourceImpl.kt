package com.cgnu.sdk.framework

import com.google.android.gms.wearable.*
import com.cgnu.sdk.util.EventUri

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
class SenderDataSourceImpl(private val sender:ISender) : SenderDataSource {


    override suspend fun sendMessage(data: ByteArray) = sender.sendMessage(data)


    /**
     * sending data with DataClient (recommended to send heavy data )
     */
    override suspend fun sendData(data: ByteArray, event: EventUri) = sender.sendData(data, event)

    /**
     * send Asset
     */
    override suspend fun sendAsset(data: Asset, assetName: String, path: String) =
        sender.sendAsset(data, assetName, path)
}
