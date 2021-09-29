package com.psa.sdk.util

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.MessageEvent
import com.psa.sdk.models.DataExchanged
import com.psa.sdk.service.AbstractWearableService
import com.psa.sdk.service.DataListener
import com.psa.sdk.service.DataListenerImpl

class WearableService: AbstractWearableService() {
    override fun getListenerValue(): DataListener {
        return DataListenerImpl(DataExchanged::class.java)
    }
}