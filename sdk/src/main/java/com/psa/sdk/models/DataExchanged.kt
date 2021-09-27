package com.psa.sdk.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.psa.sdk.util.Event

data class DataExchanged(
    @SerializedName("event") var event: Event,
    @SerializedName("content") var content: String
)
fun DataExchanged.toByteArray():ByteArray {
    return Gson().toJson(this).toByteArray()
}

fun ByteArray.toDataExchanged():DataExchanged{
    return Gson().fromJson(
        String(this),
        DataExchanged::class.java
    )
}
