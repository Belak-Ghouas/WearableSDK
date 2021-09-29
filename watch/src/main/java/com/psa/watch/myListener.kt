package com.psa.watch

import android.graphics.Bitmap
import android.net.Uri
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent
import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.service.DataListener
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.function.Supplier

class myListener<T>:DataListener {
    val flow: MutableStateFlow<ExchangedModel<T>?> = MutableStateFlow(null)
    override fun onMessageReceived(messageEvent: MessageEvent) {
        TODO("Not yet implemented")
    }

    override fun onDataChanged(data: DataItem) {
        TODO("Not yet implemented")
    }

    override fun onAssetChanged(bitmap: Bitmap, uri: Uri) {
        TODO("Not yet implemented")
    }

    override fun onDataDeleted(data: DataEvent) {
        TODO("Not yet implemented")
    }


}