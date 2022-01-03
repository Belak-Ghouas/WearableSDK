package com.psa.sdk.send

import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.models.Result

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
class SendMessageUseCase(private val senderRepository: SenderRepository) {
    suspend operator fun <U>invoke(dataModel: ExchangedModel<U>):Result<ByteArray> {
     return senderRepository.sendMessage(dataModel.toByte())
    }
}