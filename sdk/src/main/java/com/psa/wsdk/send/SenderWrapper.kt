package com.psa.wsdk.send

import android.content.Context
import com.google.android.gms.wearable.Asset
import com.psa.wsdk.models.BitmapModel
import com.psa.wsdk.models.ExchangedModel
import com.psa.wsdk.models.Result
import com.psa.wsdk.models.toAsset
import com.psa.wsdk.util.Config

/**
 *
 * @author Abdelhak GHOUAS  on 28/09/2021
 * @constructor :construct the Wrapper on the [Sender] class
 * @param context : the application context to have access to the Wearable Capability
 * @param config  : Configuration to get the capabilities on the device , and the Messages routes
 *
 * Message sent from/to watch/phone must be in the same route
 */
class SenderWrapper(context: Context, config: Config){

    private val mSender= Sender(context,config)

    fun sendAsset(bitmapModel: BitmapModel, onCompletedListener: ((Result<Asset>)->Unit )?=null) {
        mSender.sendAsset(
            bitmapModel.toAsset(),
            bitmapModel.assetName,
            bitmapModel.getPath,
            onCompletedListener
        )
    }

    /**
     * a custom layer on the [Sender] to send models and not just byteArray
     */
    fun <U>sendMessage(dataModel:ExchangedModel<U>,onCompletedListener: ((Result<U>)->Unit )?=null){
        mSender.sendMessage(dataModel.toByte()){ result ->
                onCompletedListener?.invoke(result.transform{dataModel.fromByte(it)})
        }
    }

    /**
     * a custom layer on the [Sender] to send models and not just byteArray
     *@param dataModel : the model that we want to send it be an object which implements [ExchangedModel] interface
     */
   fun <T> sendData(dataModel:ExchangedModel<T>,onCompletedListener: ((Result<T>)->Unit )?=null) {
        mSender.sendData(dataModel.toByte(),dataModel) { result->
                onCompletedListener?.invoke(result.transform {dataModel.fromByte(it)})
        }
    }



}
