package com.cgnu.sdk.service

import android.annotation.SuppressLint

/**
 *
 * @author Abdelhak GHOUAS  on 30/09/2021
 * A generic Singleton to contain the object which we want to expose data on it.
 *
 */
object Container {
    private val instances: MutableMap<String, Any> = HashMap()

    @SuppressLint
    private fun <T> instanceTypeUnsafe(name: String, vararg initargs: Any): T? {
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
                    // val gnrcType: Type? = c.genericSuperclass
                    // val parameterizedType: ParameterizedType = gnrcType as ParameterizedType
                    // val types: Array<Type> = parameterizedType.actualTypeArguments
                    for (i in initargs.indices) {
                        parameterTypes[i] = initargs[i].javaClass
                    }
                    inst = c.getConstructor(*parameterTypes).newInstance(*initargs)
                } catch (e: Throwable) {
                    System.err.println("Can't get or call constructor , it must be public")
                    e.printStackTrace()
                    return null
                }
                instances[name] = inst as Any
            }

            return c.cast(instances[name])
        }
    }


    /**
     * Due to generic erasure of java spec on the compilation time we cannot pass a generic class
     * and for that when we call this function we have to call the constructor of the [clazz] that we
     * want to use.
     * @sample : val list<User> users= instanceTypeSafe(ArrayList<User>())
     * to pass the generic class argument we must have an empty constructor
     */
    fun <T> instanceTypeSafe(clazz: Class<T>, vararg initargs: Any): T?{

        val c: Class<T> = clazz
        val name =c.canonicalName
        synchronized(this){
            if (!instances.containsKey(name)) {
                val inst: T
                try {
                    val parameterTypes: Array<Class<*>?> = arrayOfNulls(initargs.size)
                 // val gnrcType: Type? = c.genericSuperclass
                 // val parameterizedType: ParameterizedType = gnrcType as ParameterizedType
                 // val types: Array<Type> = parameterizedType.actualTypeArguments
                    for (i in initargs.indices) {
                        parameterTypes[i] = initargs[i].javaClass
                    }
                    inst = c.getConstructor(*parameterTypes).newInstance(*initargs)
                } catch (e: Throwable) {
                    System.err.println("Can't get or call constructor , it must be public")
                    e.printStackTrace()
                    return null
                }
                instances[name] = inst as Any
            }

            return c.cast(instances[name])
        }
    }
}