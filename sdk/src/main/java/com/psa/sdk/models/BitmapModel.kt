package com.psa.sdk.models

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.google.android.gms.tasks.Tasks
import com.google.android.gms.wearable.Asset
import com.google.android.gms.wearable.Wearable
import com.psa.sdk.util.EventUri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.InputStream

data class BitmapModel(val assetName: String, val bitmap: Bitmap, val uri: EventUri) {
  val getUri: Uri  get()=uri.getUri()
  val getPath: String get()=uri.getPath()
}

fun BitmapModel.toAsset():Asset {
   return ByteArrayOutputStream().let { byteStream ->
        this.bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteStream)
        Asset.createFromBytes(byteStream.toByteArray())
    }
}


