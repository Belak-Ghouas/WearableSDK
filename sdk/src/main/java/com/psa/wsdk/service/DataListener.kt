package com.psa.wsdk.service

import android.graphics.Bitmap
import android.net.Uri
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent

interface DataListener {
    fun onMessageReceived(messageEvent: MessageEvent)
    fun onDataChanged(dataItem: DataItem)
    fun onAssetChanged(bitmap: Bitmap, uri: Uri)
    fun onDataDeleted(data: DataEvent)
}