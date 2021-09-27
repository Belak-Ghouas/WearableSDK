package com.psa.sdk.util

/**
 * Config to get configuration for sending message from and to phone/watch
 * for messages we need capabilities
 * @author Abdelhak GHOUAS
 */
interface Config {

    /**
     * capability must be same as the one declared on the wear.xml file
     * in the resource values of the project
     */
    fun getCapability():String

    /**
     * the route of the message that we want to send
     * we will receive the message in the other device in this same route
     */
    fun getMessageRoute():String
}
