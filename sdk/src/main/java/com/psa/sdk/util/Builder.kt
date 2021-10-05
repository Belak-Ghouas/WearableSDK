package com.psa.sdk.util

/**
 *
 * @author Abdelhak GHOUAS
 */

interface Builder<U> {
    fun build(byte:ByteArray,jClass: Class<U>): U
}

