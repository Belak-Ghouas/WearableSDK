package com.psa.watch

import com.psa.sdk.models.DataExchanged
import com.psa.sdk.service.AbstractWearableService
import com.psa.sdk.service.DataListener
import com.psa.sdk.service.DataListenerImpl

class WearableService:AbstractWearableService() {

    override fun getListenerValue(): DataListener {
        return DataListenerImpl(DataExchanged::class.java)
    }
}