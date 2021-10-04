package com.psa.wsdk.models

import android.graphics.Bitmap
import android.net.Uri
import com.google.android.gms.wearable.Asset
import com.psa.wsdk.util.EventUri
import java.io.ByteArrayOutputStream

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


