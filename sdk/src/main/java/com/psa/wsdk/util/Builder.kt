package com.psa.wsdk.util

/**
 *
 * @author Abdelhak GHOUAS
 */

interface Builder<U> {
    fun build(byte:ByteArray,jClass: Class<U>): U
}

