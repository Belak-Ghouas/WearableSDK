package com.psa.sdk.service

import java.lang.reflect.Type

object Singleton {
    private val instances: MutableMap<String, Any> = HashMap()
    fun <T> Instance(name: String, vararg initargs: Any): T? {

        val c: Class<T> = try {
            Class.forName(name) as Class<T>
        } catch (e1: ClassNotFoundException) {
            System.err.println("ClassNotFoundException: $name")
            e1.printStackTrace()
            return null
        }
        synchronized(this){
            if (!instances.containsKey(name)) {
                val inst: T
                try {
                    val parameterTypes: Array<Class<*>?> = arrayOfNulls(initargs.size)
                    val gnrcType: Type? = c.genericSuperclass
                    // val parameterizedType: ParameterizedType = gnrcType as ParameterizedType
                    // val types: Array<Type> = parameterizedType.actualTypeArguments
                    for (i in initargs.indices) {
                        parameterTypes[i] = initargs[i].javaClass
                    }
                    inst = c.getConstructor(*parameterTypes).newInstance(*initargs)
                } catch (e: Throwable) {
                    System.err.println("Can't get or call constructor")
                    e.printStackTrace()
                    return null
                }
                instances[name] = inst as Any
            }

            return c.cast(instances[name])
        }
    }
}