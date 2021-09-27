package com.psa.sdk.service

import android.util.Log
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent

class WearableService: AbstractWearableService() {
    override fun getListenerValue(): DataListener {
        return object :DataListener{
            override fun onMessageReceived(messageEvent: MessageEvent) {
                Log.e("GROOT","MessageReceived")
            }

            override fun onDataChanged(data: DataItem) {
                Log.e("GROOT","MessageReceived")
            }

            override fun onDataDeleted(data: DataEvent) {
                Log.e("GROOT","MessageReceived")
            }

        }
    }
}