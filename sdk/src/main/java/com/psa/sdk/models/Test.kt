package com.psa.sdk.models

import android.net.Uri
import com.google.android.gms.wearable.DataEvent
import com.psa.sdk.send.Sender
import com.psa.sdk.util.Event
import com.psa.sdk.util.EventUri

class Test(sender: Sender,val event: Event): ExchangedModel<Sender> ,EventUri{
    override fun toByte(): ByteArray {
        TODO("Not yet implemented")
    }

    override fun fromByte(byteArray: ByteArray): Sender {
        TODO("Not yet implemented")
    }

    override fun getUri(): Uri {
       return event.getUri()
    }

    override fun getPath(): String {
        TODO("Not yet implemented")
    }
}