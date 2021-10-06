package com.psa.watch

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.psa.sdk.models.DataExchanged
import com.psa.sdk.send.SenderWrapper
import com.psa.sdk.service.DataFlow
import com.psa.sdk.service.FlowHandler
import com.psa.sdk.service.Container
import com.psa.sdk.util.Config
import com.psa.sdk.util.Event
import com.psa.sdk.util.observe
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    private lateinit var buttonM: Button
    private lateinit var buttonD: Button
    lateinit var text: TextView
    var data = MutableLiveData<String>()
    private val flowProvider: DataFlow<DataExchanged>? = Container.instanceTypeSafe(FlowHandler<DataExchanged>().javaClass)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sender = SenderWrapper(this, object : Config {
            override fun getCapability(): String {
                return "messages"
            }

            override fun getMessageRoute(): String {
                return "/messages"
            }

            override fun getDataPrefixPath(): String {
                return "/from_watch"
            }
        })

        buttonM = findViewById(R.id.send_message)
        buttonD=findViewById(R.id.send_data)
        text = findViewById(R.id.text)
        buttonM.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            sender.sendMessage(DataExchanged(Event.CommandCharging, "Message from watch at $time")) {
                Log.e("Completed", it.toString())
            }
        }

        buttonD.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            sender.sendData(DataExchanged(Event.CommandCharging, "Data from Watch at $time")) {
                Log.e("Completed", it.toString())
            }
        }


        data.observe(this, {
            text.text = it
        })

        flowProvider?.messageFlow?.observe(lifecycleScope) {
            data.postValue(it?.content.toString())
        }

        flowProvider?.dataFlow?.observe (lifecycleScope){
            data.postValue(it?.content.toString())
        }

    }
}