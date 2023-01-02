package com.cgnu.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cgnu.sdk.models.ExchangedModel
import com.cgnu.sdk.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 03/01/2022
 */
class MainActivityViewModel(private val sendMessageUseCase: SendMessageUseCase) : ViewModel() {

    fun <U> sendMessage(dataModel: ExchangedModel<U>, callBack:((Result<U>)->Unit)?=null){
        viewModelScope.launch(Dispatchers.IO){
           val result= sendMessageUseCase.invoke(dataModel)
            callBack?.invoke(result)
        }
    }

    fun <U> sendData(dataModel: ExchangedModel<U>, callBack:((Result<U>)->Unit)?=null){
        viewModelScope.launch(Dispatchers.IO){
            val result= sendMessageUseCase.invoke(dataModel)
            callBack?.invoke(result)
        }
    }
}