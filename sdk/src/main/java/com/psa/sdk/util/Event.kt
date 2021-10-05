package com.psa.sdk.util

import android.net.Uri

enum class Event: EventUri {

    RequestPinCode ,
    ResponsePinCode,
    ResponsePinCodeOK,
    ResponsePinCodeKO,


    CommandRequestStartPreCondition,
    CommandRequestStopPreCondition,
    CommandCharging,

    ERROR,
    RequestAuthenticated,
    ResponseAuthenticated,

    RequestVehicleData,
    ResponseVehicleData,
    ResponseLevData,

    IMAGE_PATH,
    TIME_OUT,
    RequestChangeVehicle,
    EMPTY;

    override fun getUri(): Uri {
        return  Uri.EMPTY
    }

    override fun getPath(): String {
        return  "/"+this.name
    }

}
