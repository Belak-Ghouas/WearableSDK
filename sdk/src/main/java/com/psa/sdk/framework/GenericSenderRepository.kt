package com.psa.sdk.framework

import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.models.Result

/**
 * @author Abdelhak GHOUAS
 * Created 06/01/2022
 */
class GenericSenderRepository(private val senderDataSource: SenderDataSource) {

    /**
     * a custom layer on the [Sender] to send models and not just byteArray
     */
    suspend fun <U> sendMessage(dataModel: ExchangedModel<U>): Result<U> {
        return senderDataSource.sendMessage(dataModel.toByte()).transform { dataModel.fromByte(it) }
    }

    /**
     * a custom layer on the [Sender] to send models and not just byteArray
     *@param dataModel : the model that we want to send it be an object which implements [ExchangedModel] interface
     */
    suspend fun <T> sendData(dataModel: ExchangedModel<T>): Result<T> {
        return senderDataSource.sendData(dataModel.toByte(), dataModel).transform { dataModel.fromByte(it) }
    }
}