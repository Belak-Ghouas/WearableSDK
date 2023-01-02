package com.cgnu.watch

import com.google.gson.Gson
import com.cgnu.sdk.models.DataExchanged
import com.cgnu.sdk.service.AbstractWearableService
import com.cgnu.sdk.service.DataListener
import com.cgnu.sdk.service.DataListenerImpl
import com.cgnu.sdk.util.Builder

class WearableService: AbstractWearableService() {
    override fun getListenerValue(): DataListener {
        return DataListenerImpl(DataExchanged::class.java,object : Builder<DataExchanged> {
            override fun build(byte: ByteArray, jClass: Class<DataExchanged>): DataExchanged {
                return Gson().fromJson(
                    String(byte),
                    jClass
                )
            }
        })
    }
}