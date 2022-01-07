package com.psa.app.util

import com.google.gson.Gson
import com.psa.sdk.models.DataExchanged
import com.psa.sdk.service.AbstractWearableService
import com.psa.sdk.service.DataListenerImpl
import com.psa.sdk.util.Builder

class WearableService: AbstractWearableService() {
    override fun getListenerValue()=DataListenerImpl(DataExchanged::class.java, object : Builder<DataExchanged> {
            override fun build(byte: ByteArray, jClass: Class<DataExchanged>): DataExchanged {
                return Gson().fromJson(
                    String(byte),
                    jClass
                )
            }
        })

}