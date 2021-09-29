package com.psa.sdk.util

import com.google.gson.Gson

/**
 *
 * @author Abdelhak GHOUAS
 */
class BuilderImp<U> :Builder<U>{
    val  gson = Gson()
     override fun build(byte: ByteArray, jClass:Class<U>): U {
         return if (byte is ByteArray){
             Gson().fromJson(
                 String(byte),
                 jClass
             )
         }else  Gson().fromJson(
             String(ByteArray(0)),
             jClass
         )
    }

 /*   class BuilderM<T>(private val instantiator: Supplier<T>) {
        private val instanceModifiers: MutableList<Consumer<T>> = ArrayList()

        fun <U> with(consumer: BiConsumer<T, U>, value: U): BuilderM<T> {
            val c: Consumer<T> = Consumer<T> { instance -> consumer.accept(instance, value) }
            instanceModifiers.add(c)
            return this
        }

        fun build(): T {
            val value: T = instantiator.get()
            instanceModifiers.forEach { modifier: Consumer<T> ->
                modifier.accept(
                    value
                )
            }
            instanceModifiers.clear()
            return value
        }

        companion object {
            fun <T> of(instantiators: Supplier<T>): BuilderM<T> {
                return BuilderM(instantiators)
            }
        }

    }*/
}