package com.psa.sdk.send

import android.content.Context
import com.google.android.gms.wearable.Asset
import com.psa.sdk.models.BitmapModel
import com.psa.sdk.models.ExchangedModel
import com.psa.sdk.models.Result
import com.psa.sdk.models.toAsset
import com.psa.sdk.util.Config

/**
 *
 * @author Abdelhak GHOUAS  on 28/09/2021
 */
class SenderWrapper(context: Context, config: Config){
    @PublishedApi()
   internal val mSender= Sender(context,config)

    fun sendAsset(bitmapModel: BitmapModel, onCompletedListener: ((Result<Asset>)->Unit )?=null) {
        mSender.sendAsset(
            bitmapModel.toAsset(),
            bitmapModel.assetName,
            bitmapModel.getPath,
            onCompletedListener
        )
    }

    fun <U>sendMessage(dataModel:ExchangedModel<U>,onCompletedListener: ((Result<U>)->Unit )?=null){
        mSender.sendMessage(dataModel.toByte()){ result ->
                onCompletedListener?.invoke(result.transform{dataModel.fromByte(it)})
        }
    }

   fun < U> sendData(dataModel:ExchangedModel<U>,onCompletedListener: ((Result<U>)->Unit )?=null) {
        mSender.sendData(dataModel.toByte(),dataModel) { result->
                onCompletedListener?.invoke(result.transform {dataModel.fromByte(it)})
        }
    }



}
