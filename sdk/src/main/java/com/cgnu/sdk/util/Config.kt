package com.cgnu.sdk.util

/**
 * Config to get configuration for sending message from and to phone/watch
 * for messages we need capabilities and Route
 * @author Abdelhak GHOUAS
 */
interface Config {

    /**
     * capability must be same as the one declared on the wear.xml file
     * in the resource values of the project
     */
    fun getCapability():String

    /**
     * the route that we want to send messages on it
     * we will receive the message in the other device in this same route
     */
    fun getMessageRoute():String


    /**
     * the prefix path for sending data
     * to not receive callbacks when you sendData
     */
    fun getDataPrefixPath():String
}
