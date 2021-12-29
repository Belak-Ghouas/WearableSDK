package com.psa.sdk.send

import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.models.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
class SendMessageUseCase(private val senderRepository: SenderRepository) {
    operator fun <U>invoke(dataModel: ExchangedModel<U>, onCompletedListener: ((Result<U>)->Unit )?=null, coroutineScope: CoroutineScope){
        coroutineScope.launch {
             senderRepository.sendMessage(dataModel.toByte()){result->
                 val tmp  =result.transform{dataModel.fromByte(it)}
                 onCompletedListener?.invoke(tmp)
             }

        }

    }
}