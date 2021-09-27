package com.psa.sdk.util

import com.google.gson.Gson

/**
 *
 * @author Abdelhak GHOUAS
 */
class BuilderImp<in T, out U> :Builder<T,U> {
    val  gson = Gson()
     override fun < T, U> build(byte: T, jClass:Class<U>): U {
         return if (byte is ByteArray){
             Gson().fromJson(
                 String(byte as ByteArray),
                 jClass
             )
         }else  Gson().fromJson(
             String(ByteArray(0)),
             jClass
         )
    }

}