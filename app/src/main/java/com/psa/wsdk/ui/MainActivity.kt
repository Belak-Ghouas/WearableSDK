package com.psa.wsdk.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.psa.wsdk.R
import com.psa.wsdk.models.DataExchanged
import com.psa.wsdk.send.SenderWrapper
import com.psa.wsdk.service.DataFlow
import com.psa.wsdk.service.FlowHandler
import com.psa.wsdk.service.Container
import com.psa.wsdk.util.Config
import com.psa.wsdk.util.Event
import com.psa.wsdk.util.observe
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class MainActivity:AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var text : TextView
    private var data= MutableLiveData<String>()
    private val flowProvider:DataFlow<DataExchanged>? = Container.instanceTypeSafe(FlowHandler<DataExchanged>().javaClass)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sender= SenderWrapper(this,object: Config {
            override fun getCapability(): String {
                return  "messages"
            }

            override fun getMessageRoute(): String {
                return "/messages"
            }
        })

        button=findViewById(R.id.send_message)
        text=findViewById(R.id.text)
        button.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            sender.sendMessage(DataExchanged(Event.CommandCharging, "hello from Phone at $time")) {
                Log.e("Completed", it.toString())
            }
        }
        data.observe(this,{
            text.text=it
        })

        flowProvider?.messageFlow?.observe(lifecycleScope) {
            data.postValue(it?.content.toString())
        }
    }
}