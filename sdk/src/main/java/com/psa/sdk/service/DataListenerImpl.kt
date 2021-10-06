package com.psa.sdk.service

import android.graphics.Bitmap
import android.net.Uri
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent
import com.psa.sdk.util.Builder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Sample of custom Listener for messages and data on the device
 * The listener will be triggered by the [AbstractWearableService] on each event
 * To expose this Data i put it inside A Singleton [Container] object which have an instance
 * of [DataFlow] which we can observe the DATA
 *
 * @author Abdelhak GHOUAS on 30/09/2021
 */
class DataListenerImpl<T>(private val jClass: Class<T>,val builder: Builder<T>) : DataListener {
    private var flowProvider: DataFlow<T>? = Container.instanceTypeSafe(FlowHandler<T>()::class.java)

    override fun onMessageReceived(messageEvent: MessageEvent) {
        // to avoid buffer closed if we go inside and the coroutine is suspended
        val byte=messageEvent.data
        CoroutineScope(Dispatchers.IO).launch {
            flowProvider?.messageFlow?.emit( builder.build(byte,jClass))
        }
    }

    override fun onDataChanged(dataItem: DataItem) {
        // to avoid buffer closed if we go inside and the coroutine is suspended
        val byte=dataItem.data
        CoroutineScope(Dispatchers.IO).launch {
            flowProvider?.dataFlow?.emit( builder.build(byte,jClass))
        }
    }

    override fun onAssetChanged(bitmap: Bitmap, uri: Uri) {
        CoroutineScope(Dispatchers.IO).launch {
            flowProvider?.assetFlow?.emit(bitmap)
        }
    }


    override fun onDataDeleted(data: DataEvent) {
        TODO("Not yet implemented")
    }
}

