package com.psa.sdk.service


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.android.gms.wearable.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream

abstract class AbstractWearableService : WearableListenerService() {
    private val listener: DataListener by lazy { getListenerValue()}
    private val tag="WearableService"
   lateinit var  context:Context
    override fun onCreate() {
        super.onCreate()
        Log.e(tag, "OnCreate")
        context=this
    }
    override fun onMessageReceived(event: MessageEvent) {
        listener.onMessageReceived(event)
    }

    override fun onDataChanged(events: DataEventBuffer) {

        events
            .filter { it.type == DataEvent.TYPE_CHANGED }
            .forEach { event ->
                Log.e("onDataChanged", event.dataItem.uri.toString())
                if(event.dataItem.assets.isEmpty()){
                    listener.onDataChanged(event.dataItem)
                }else{
                    DataMapItem.fromDataItem(event.dataItem)
                        .dataMap.getAsset("IMAGE_NAME")
                        .let { asset ->
                            loadBitmapFromAsset(asset) {
                                it?.let {
                                    listener.onAssetChanged(it,event.dataItem.uri)
                                }
                                Log.e(tag,"receiveImage")
                            }
                        }
                }

            }

    }

    abstract fun getListenerValue(): DataListener

    private fun loadBitmapFromAsset(asset: Asset?, callback: (bitmap: Bitmap?) -> Unit) {
        // convert asset into a file descriptor and block until it's ready

        CoroutineScope(Dispatchers.IO).launch {
            asset?.let {
                val assetInputStream: InputStream? =
                    Tasks.await(Wearable.getDataClient(context).getFdForAsset(asset))?.inputStream

                val bitmap = assetInputStream?.let { inputStream ->

                    BitmapFactory.decodeStream(inputStream)
                } ?: run {
                    null
                }
                callback.invoke(bitmap)
            }

        }
    }

    private fun loadInputStreamFromAsset(asset: Asset?, callback: (inputStream: InputStream?) -> Unit) {
        // convert asset into a file descriptor and block until it's ready

        CoroutineScope(Dispatchers.IO).launch {
            asset?.let {
                val assetInputStream: InputStream? =
                    Tasks.await(Wearable.getDataClient(context).getFdForAsset(asset))?.inputStream
                callback.invoke(assetInputStream)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag,"onDestroy")
    }

}
