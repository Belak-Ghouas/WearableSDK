package com.psa.wsdk.models

import com.psa.wsdk.util.EventUri


interface ExchangedModel<out T>:EventUri{
    fun toByte():ByteArray
    fun fromByte(byteArray: ByteArray):T
}