# WearableSDK

This Sdk is made by [Abdelhak GHOUAS](https://github.com/ghouasabdelhak)

It allow us to communicate between phone and watch in the most easiest way with asynchronous messages.
It support background mode and when the is Killed.
The purpose of this extension is not just for communication but it can be also reusable(Src code + companion sdk) for any new or existing application.


#### Uses and Installation
To make this sdk work on your project :
1. First you must add the SDK library in your project (gradle or maven app layer)
```kotlin
implementation(project(":sdk"))
```
2. After that make sure you have the file `wear.xml`  in your app `res\values\wear.xml` and inside this file you must
   have the capabilities of the device like [a relative link](/sdk/src/main/res/values/wear.xml) and put inside the capabilities of
   the wearable (this file must be in the phone and watch) and have the same values.
```xml
   <resources xmlns:tools="http://schemas.android.com/tools"
    tools:keep="@array/android_wear_capabilities">
   <string-array name="android_wear_capabilities">
   <item>messages</item>
   </string-array>
   </resources>
```
3. Third one you have this configuration file , now you have to implements the [a relative link](/sdk/src/main/java/com/psa/sdk/service/AbstractWearableService.kt)
   there is one abstract Method and it's a Listener to get the Data from the service.
   it's more efficient with an example.
   
```kotlin
 class WearableService: AbstractWearableService() {
   override fun getListenerValue(): DataListener {
      return DataListenerImpl(DataExchanged::class.java,object :Builder<DataExchanged>{
         override fun build(byte: ByteArray, jClass: Class<DataExchanged>): DataExchanged {
            return Gson().fromJson(
               String(byte),
               jClass
            )
         }
      })
   }
}
```
   So we override the method,in it's constructor we need the `Class` model we Exchange on the phone/watch communication , and a builder also to build the `ByteArray` received to a model.
   This sample Listener implements the [a relative link](/sdk/src/main/java/com/psa/sdk/service/DataListener.kt), for more readability,clarity and comprehension,
   i created a custom implementation for this Interface , and there is how it look.
```kotlin
/**
 * Here we expose the Data received inside a Singleton Provider which store inside a [DataFlow] object
 */
class DataListenerImpl<T>(private val jClass: Class<T>,val builder: Builder<T>) : DataListener {
   private var flowProvider: DataFlow<T>? = Provider.instanceTypeSafe(FlowHandler<T>()::class.java)
   
   override fun onMessageReceived(messageEvent: MessageEvent) {
      CoroutineScope(Dispatchers.IO).launch {
         flowProvider?.messageFlow?.emit( builder.build(messageEvent.data,jClass))
      }
   }
   /**
    * we show just one method
    */
}
```
   Once we create the Service we must add it to the `Manifest.xml` file.
   ##### **Pay attention**
   your file must contains this lines
```xml
    <!-- for the watch-->
<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.psa.sdk">
   <uses-permission android:name="android.permission.WAKE_LOCK" />
   
   <service android:name="com.psa.sdk.util.WearableService" android:enabled="true" android:exported="true">
   <intent-filter>
      <action android:name="com.google.android.gms.wearable.DATA_CHANGED" />
      <action android:name="com.google.android.gms.wearable.MESSAGE_RECEIVED" />
      <data android:scheme="wear" android:host="*" android:path="/messages" /><!-- path must be the same as wearables capability in wear.xml and a / before-->
   </intent-filter>
</service>
</manifest>
```
4. Fourth item