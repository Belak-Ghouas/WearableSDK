package com.psa.sdk.framework

import com.google.android.gms.wearable.Asset
import com.psa.sdk.models.BitmapModel
import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.models.Result
import com.psa.sdk.models.toAsset

/**
 *
 * @author Abdelhak GHOUAS  on 28/09/2021
 * @constructor :construct the Wrapper on the [Sender] class
 * @param sender : the real sender object who send data/message as byteArray
 *
 * Message sent from/to watch/phone must be in the same route
 */
class SenderWrapper(private val sender: ISender) {


    suspend fun sendAsset(bitmapModel: BitmapModel): Result<Asset> {
        return sender.sendAsset(
            bitmapModel.toAsset(),
            bitmapModel.assetName,
            bitmapModel.getPath
        )
    }

    /**
     * a custom layer on the [Sender] to send models and not just byteArray
     */
    suspend fun <U> sendMessage(dataModel: ExchangedModel<U>): Result<U> {
        return sender.sendMessage(dataModel.toByte()).transform { dataModel.fromByte(it) }
    }

    /**
     * a custom layer on the [Sender] to send models and not just byteArray
     *@param dataModel : the model that we want to send it be an object which implements [ExchangedModel] interface
     */
    suspend fun <T> sendData(dataModel: ExchangedModel<T>): Result<T> {
        return sender.sendData(dataModel.toByte(), dataModel).transform { dataModel.fromByte(it) }
    }

}
