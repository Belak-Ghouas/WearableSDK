package com.cgnu.sdk.models

import com.cgnu.sdk.util.EventUri


interface ExchangedModel<out T>: EventUri {
    fun toByte():ByteArray
    fun fromByte(byteArray: ByteArray):T
}