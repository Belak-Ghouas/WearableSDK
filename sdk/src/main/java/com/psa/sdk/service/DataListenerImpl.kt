package com.psa.sdk.service

import android.graphics.Bitmap
import android.net.Uri
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent
import com.google.gson.Gson
import com.psa.sdk.models.DataExchanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class DataListenerImpl<T>(private val jClass: Class<T>) : DataListener {

    companion object {

      /*  var dataFlow: MutableStateFlow<DataExchanged?> = MutableStateFlow(null)
        var messageFlow: MutableStateFlow<DataExchanged?> = MutableStateFlow(null)
        var assetFlow: Flow<Bitmap?> = MutableStateFlow(null)*/
       // var t:FlowHandler<DataExchanged>?  = Singleton.Instance("com.psa.sdk.service.FlowHandler")
        //var flowProvider:DataFlow<DataExchanged>? =Singleton.Instance("com.psa.sdk.service.FlowHandler")
    }


    override fun onMessageReceived(messageEvent: MessageEvent) {
        CoroutineScope(Dispatchers.IO).launch {
           val  flowProvider:DataFlow<T>?= Singleton.Instance("com.psa.sdk.service.FlowHandler")
            flowProvider?.messageFlow?.emit(Gson().fromJson(String(messageEvent.data), jClass))
        }
    }

    override fun onDataChanged(dataItem: DataItem) {
        CoroutineScope(Dispatchers.IO).launch {
            val  flowProvider:DataFlow<T>?= Singleton.Instance("com.psa.sdk.service.FlowHandler")
            flowProvider?.dataFlow?.emit(Gson().fromJson(String(dataItem.data), jClass))
        }
    }

    override fun onAssetChanged(bitmap: Bitmap, uri: Uri) {
        CoroutineScope(Dispatchers.IO).launch {
            val  flowProvider:DataFlow<T>?= Singleton.Instance("com.psa.sdk.service.FlowHandler")
            flowProvider?.assetFlow?.emit(bitmap)
        }
    }


    override fun onDataDeleted(data: DataEvent) {
        TODO("Not yet implemented")
    }
}

