package com.cgnu.app.ui

import com.cgnu.sdk.models.ExchangedModel
import com.cgnu.sdk.models.Result
import com.cgnu.sdk.framework.SenderRepository

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
class SendMessageUseCase(private val senderRepository: SenderRepository) {
    suspend operator fun <U>invoke(dataModel: ExchangedModel<U>):Result<U> {
     return senderRepository.sendMessage(dataModel.toByte()).transform {dataModel.fromByte(it)}
    }
}