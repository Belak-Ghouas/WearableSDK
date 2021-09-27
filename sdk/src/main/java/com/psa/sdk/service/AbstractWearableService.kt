package com.psa.sdk.service


import android.os.IBinder
import android.util.Log
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService

abstract class AbstractWearableService() : WearableListenerService() {
    private val listener:DataListener  by lazy { getListenerValue()}


    override fun onMessageReceived(event: MessageEvent) {
        listener.onMessageReceived(event)
    }

    override fun onDataChanged(events: DataEventBuffer) {
        //to avoid time out
        events
            .filter { it.type == DataEvent.TYPE_CHANGED }
            .forEach { event ->
                Log.e("onDataChanged", event.dataItem.uri.toString())
               listener.onDataChanged(event.dataItem)
            }

    }

    abstract fun getListenerValue():DataListener

}
