package com.psa.sdk.service

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent
import com.psa.sdk.util.Builder


/**
 * Sample of custom Listener for messages and data on the device
 * The listener will be triggered by the [AbstractWearableService] on each event
 * To expose this Data i put it inside A Singleton [Container] object which have an instance
 * of [FlowHandler] which we can observe the DATA
 *
 * @author Abdelhak GHOUAS on 30/09/2021
 */
class DataListenerImpl<T>(private val jClass: Class<T>, private val builder: Builder<T>) :
    DataListener {
    private var flowHandler = Container.instanceTypeSafe(FlowHandler<T>()::class.java)

    override fun onMessageReceived(messageEvent: MessageEvent) {
        // to avoid buffer closed if we go inside and the coroutine is suspended
        Log.e("Abdelhak","onMessageReceived")
        val byte = messageEvent.data
        flowHandler?.messageFlow?.tryEmit(builder.build(byte, jClass))

    }

    override fun onDataChanged(dataItem: DataItem) {
        // to avoid buffer closed if we go inside and the coroutine is suspended
        Log.e("Abdelhak","onDataChanged ")
        val byte = dataItem.data
        flowHandler?.dataFlow?.tryEmit(builder.build(byte, jClass))
    }

    override fun onAssetChanged(bitmap: Bitmap, uri: Uri) {
        flowHandler?.assetFlow?.tryEmit(bitmap)
    }


    override fun onDataDeleted(data: DataEvent) {
        TODO("Not yet implemented")
    }
}

