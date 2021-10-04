package com.psa.wsdk.service

import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * References a generic type.
 *
 * @author crazybob@google.com (Bob Lee)
 */
abstract class TypeReference<T> {

    protected constructor() {
        val superclass: Type = javaClass.genericSuperclass
        if (superclass is Class<*>) {
            throw RuntimeException("Missing type parameter.")
        }
        type = (superclass as ParameterizedType).actualTypeArguments[0]
    }

    private val type: Type

    @Volatile
    private var constructor: Constructor<*>? = null

    /**
     * Instantiates a new instance of `T` using the default, no-arg
     * constructor.
     */
    @Throws(
        NoSuchMethodException::class,
        IllegalAccessException::class,
        InvocationTargetException::class,
        InstantiationException::class
    )
    fun newInstance(vararg initargs: Any): T {
        if (constructor == null) {
            val rawType =
                if (type is Class<*>) type else ((type as ParameterizedType).rawType as Class<*>)
            constructor = rawType.getConstructor()
        }
        return constructor?.newInstance() as T
    }


}
