package com.psa.watch

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.psa.sdk.models.DataExchanged
import com.psa.sdk.framework.SenderWrapper
import com.psa.sdk.service.Container
import com.psa.sdk.service.FlowHandler
import com.psa.sdk.util.Event
import com.psa.sdk.util.observe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    private lateinit var buttonM: Button
    private lateinit var buttonD: Button
    lateinit var text: TextView
    var data = MutableLiveData<String>()
    private val sender :SenderWrapper by inject()
    private val flowProvider = Container.instanceTypeSafe(FlowHandler<DataExchanged>().javaClass)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonM = findViewById(R.id.send_message)
        buttonD=findViewById(R.id.send_data)
        text = findViewById(R.id.text)
        buttonM.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            lifecycleScope.launch(Dispatchers.IO){
                sender.sendMessage(DataExchanged(Event.CommandCharging, "Message from watch at $time"))
            }

        }

        buttonD.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            lifecycleScope.launch(Dispatchers.IO) {
                sender.sendData(DataExchanged(Event.CommandCharging, "Data from Watch at $time"))
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