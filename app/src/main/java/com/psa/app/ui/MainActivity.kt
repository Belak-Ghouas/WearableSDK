package com.psa.app.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.wearable.Wearable
import com.psa.app.R
import com.psa.sdk.models.DataExchanged
import com.psa.sdk.service.Container
import com.psa.sdk.service.FlowHandler
import com.psa.sdk.util.Event
import com.psa.sdk.util.observe
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class MainActivity:AppCompatActivity() {
    private lateinit var buttonM: Button
    private lateinit var buttonD: Button
    private lateinit var text: TextView
    private var data = MutableLiveData<String>()
    private val flowHandler: FlowHandler<DataExchanged>? = Container.instanceTypeSafe(FlowHandler<DataExchanged>().javaClass)
    private lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = getViewModel()


        buttonM = findViewById(R.id.send_message)
        buttonD = findViewById(R.id.send_data)
        text = findViewById(R.id.text)
        buttonM.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())


            viewModel.sendMessage(
                DataExchanged(
                    Event.CommandCharging,
                    "Message from Phone at $time"
                )
            )
        }

        buttonD.setOnClickListener {
            val time = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now())
            viewModel.sendData(
                DataExchanged(
                    Event.RequestVehicleData,
                    "Data from Phone at $time"
                )
            ) {

            }
            val dataClient = Wearable.getDataClient(this)
            val uri = Uri.parse("wear://*" + Event.CommandCharging.getPath())
            dataClient.getDataItems(uri).addOnSuccessListener {
                if (it.count > 0) {
                    Log.e("found", String(it[0].data))
                }
                it.release()
            }

            data.observe(this, {
                text.text = it
            })

            flowHandler?.messageFlow?.observe(lifecycleScope) {
                data.postValue(it?.content.toString())
            }

            flowHandler?.dataFlow?.observe(lifecycleScope) {
                data.postValue(it?.content.toString())
            }
        }

    }
}