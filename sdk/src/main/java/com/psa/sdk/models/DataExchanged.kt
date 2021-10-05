package com.psa.sdk.models

import android.net.Uri
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.psa.sdk.util.Event

data class DataExchanged(
    @SerializedName("event")
    var event: Event,
    @SerializedName("content")
    var content:String ): ExchangedModel<DataExchanged> {

    override fun toByte(): ByteArray {
        return Gson().toJson(this).toByteArray()
    }

    override fun fromByte(byteArray: ByteArray): DataExchanged {
      return  Gson().fromJson(String(byteArray),this::class.java)
    }

    override fun getUri(): Uri {
       return event.getUri()
    }

    override fun getPath(): String {
        return event.getPath()
    }
}

