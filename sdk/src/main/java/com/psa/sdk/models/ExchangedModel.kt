package com.psa.sdk.models

import com.psa.sdk.util.EventUri


interface ExchangedModel<out T>: EventUri {
    fun toByte():ByteArray
    fun fromByte(byteArray: ByteArray):T
}