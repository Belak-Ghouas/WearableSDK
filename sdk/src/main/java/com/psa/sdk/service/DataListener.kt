package com.psa.sdk.service

import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent

interface DataListener {
    fun onMessageReceived(messageEvent: MessageEvent)
    fun onDataChanged(data: DataItem)
    fun onDataDeleted(data: DataEvent)
}