package com.psa.sdk.send

import android.content.Context
import com.google.android.gms.wearable.Asset
import com.psa.sdk.models.*
import com.psa.sdk.util.Builder
import com.psa.sdk.util.BuilderImp
import com.psa.sdk.util.Config

/**
 *
 * @author Abdelhak GHOUAS
 */
class SenderWrapper<T>(private val klass: Class<T>, context: Context, config: Config, private val  builder: Builder<ByteArray,T>){
    private val mSender= Sender(context,config)

    fun sendAsset(bitmapModel: BitmapModel, onCompletedListener: ((Result<Asset>)->Unit )?=null) {
        mSender.sendAsset(
            bitmapModel.toAsset(),
            bitmapModel.assetName,
            bitmapModel.getPath,
            onCompletedListener
        )
    }


    fun sendData(dataModel:DataExchanged,onCompletedListener: ((Result<T>)->Unit )?=null) {
        mSender.sendData(dataModel.toByteArray(),dataModel.event) {result->
            onCompletedListener?.invoke(result.transform { builder.build(it,klass) })

//            when(result){
//                is  Result.Success -> onCompletedListener?.invoke(
//                    Result.Success(builder.build(result.value,klass)))
//                is Result.Failure-> onCompletedListener?.invoke(Result.Failure(result.message,result.throwable))
//                is Result.Cancelled->onCompletedListener?.invoke(Result.Cancelled())
//                is Result.Unknown -> onCompletedListener?.invoke(Result.Unknown())
//            }
        }
    }

    fun sendMessage(dataModel:DataExchanged,onCompletedListener: ((Result<T>)->Unit )?=null){
        mSender.sendMessage(dataModel.toByteArray()){ result ->
           onCompletedListener?.invoke(result.transform { builder.build(it,klass) })
        }
    }



}
