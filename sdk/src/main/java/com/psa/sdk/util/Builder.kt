package com.psa.sdk.util

/**
 *
 * @author Abdelhak GHOUAS
 */

interface Builder<in T , out U> {
    fun <T,U> build(byte: T,jClass: Class<U>): U
}

