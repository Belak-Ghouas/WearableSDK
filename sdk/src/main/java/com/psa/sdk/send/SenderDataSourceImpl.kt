package com.psa.sdk.send

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.android.gms.wearable.*
import com.psa.sdk.models.Result
import com.psa.sdk.util.Config
import com.psa.sdk.util.EventUri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.lang.IllegalStateException
import kotlin.coroutines.resume

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */
class SenderDataSourceImpl(private val context: Context, private val config: Config): SenderDataSource {

    private val tag=this.javaClass.toString()
    private val route:String  get() = config.getMessageRoute()
    private val capability:String get() = config.getCapability()
    private val capabilityClient = Wearable.getCapabilityClient(context)


    override suspend fun sendMessage(data: ByteArray): Result<ByteArray> = suspendCancellableCoroutine{coroutine->

            capabilityClient.getCapability(capability, CapabilityClient.FILTER_REACHABLE)
                .addOnSuccessListener {
                    if (it.nodes.isEmpty()) {
                        coroutine.resume(Result.Failure("Empty Nodes",IllegalStateException()))

                    } else it.nodes.forEach { node ->
                        Wearable.getMessageClient(context).sendMessage(
                            node.id,
                            route, data
                        ).addOnSuccessListener {
                            Log.d(tag, "sendMessage success ")
                          coroutine.resume(Result.Success(data))

                        }.addOnFailureListener { exception ->
                            Log.d(tag, "sendMessage failure")
                            coroutine.resume(Result.Failure(exception.message, exception))
                        }
                    }

        }

    }


    /**
     * sending data with DataClient (recommended to send heavy data )
     */
    override suspend fun  sendData(data: ByteArray, event: EventUri, onCompletedListener: ((Result<ByteArray>)->Unit )?){
        withContext(Dispatchers.IO){
        val dataClient = Wearable.getDataClient(context)
        val path = config.getDataPrefixPath()+event.getPath()
        val putDataReq = PutDataRequest.create(path)
        putDataReq.data= data
        putDataReq.setUrgent()
        val putDataTask: Task<DataItem> = dataClient.putDataItem(putDataReq)

        putDataTask.addOnSuccessListener {
            checkNotNull(onCompletedListener).apply {
                invoke(Result.Success(data))
            }
        }
        putDataTask.addOnFailureListener {exception->
            checkNotNull(onCompletedListener).apply {
                invoke(Result.Failure(exception.message,exception))
            }
        }
        putDataTask.addOnCanceledListener {
            checkNotNull(onCompletedListener).apply {
                invoke(Result.Cancelled())
            }
        }
        }
    }


    /**
     * send Asset
     */
    override suspend fun sendAsset(data:Asset, assetName:String, path:String, onCompletedListener: ((Result<Asset>) ->Unit )?){
        withContext(Dispatchers.IO){
            val dataClient = Wearable.getDataClient(context)
            /*val asset = ByteArrayOutputStream().let { byteStream ->
                .compress(Bitmap.CompressFormat.PNG, 100, byteStream)
                Asset.createFromBytes(byteStream.toByteArray())
            }*/
            val dataMap = PutDataMapRequest.create(path)
            dataMap.dataMap.putAsset(assetName, data)
            val request = dataMap.asPutDataRequest()
            request.setUrgent()

            val dataItemTask: Task<DataItem> = dataClient.putDataItem(request)

            dataItemTask.addOnSuccessListener {
                checkNotNull(onCompletedListener).apply {
                    invoke(Result.Success(data))
                }
            }
            dataItemTask.addOnFailureListener {exception->
                checkNotNull(onCompletedListener).apply {
                    invoke(Result.Failure(exception.message,exception))
                }
            }
        }

    }

    /*    inline fun <reified T> addListener(task: Task<DataItem>, crossinline listener:(Result<T>)->Unit) {
            task.addOnSuccessListener {
                listener.invoke(Result.Success(it.data as T))
            }
            task.addOnFailureListener {
                listener.invoke(Result.Failure(it.message,it))
            }
            task.addOnCanceledListener {
                    listener.invoke(Result.Cancelled())
            }
        }*/


}
