package com.psa.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.models.Result
import com.psa.sdk.send.SendMessageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 03/01/2022
 */
class MainActivityViewModel(private val sendMessageUseCase: SendMessageUseCase) : ViewModel() {

    fun <U> sendMessage(dataModel: ExchangedModel<U>, callBack:((Result<ByteArray>)->Unit)?=null){
        viewModelScope.launch(Dispatchers.IO){
           val result= sendMessageUseCase.invoke(dataModel)
            callBack?.invoke(result)
        }
    }
}