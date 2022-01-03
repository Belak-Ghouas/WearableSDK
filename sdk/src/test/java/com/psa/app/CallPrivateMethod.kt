package com.psa.app
import java.lang.reflect.Method
import kotlin.reflect.KFunction

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 31/12/2021
 */

/**
 * when we want to test a private method without exposing this method onto public
 */
inline fun <reified T> callPrivateMethod(objectInstance: Any, methodName: String, vararg args: Any?): T? {
    val privateMethod: Method? =
        objectInstance::javaClass.get().declaredMethods.find { method -> return@find method.name == methodName }
    privateMethod?.let {
        it.isAccessible = true
        if (it.isAccessible) {
            when(val result = it.invoke(objectInstance, *args)){
                is T -> { return result}
                else -> throw NoSuchMethodException("Method $methodName does not exist in ${objectInstance::class.qualifiedName} with this return type")
            }

        }
        throw IllegalAccessException("Method $methodName could not be made accessible")

    }
    throw NoSuchMethodException("Method $methodName does not exist in ${objectInstance::class.qualifiedName}")
}


fun callPrivateFunction(objectInstance: Any, methodName: String, vararg args: Any?): Any? {

    val privateMethod: KFunction<*>? =
        objectInstance::class.members.find { t -> return@find t.name == methodName } as KFunction<*>?

    val argList = args.toMutableList()
    (argList as ArrayList).add(0, objectInstance)
    val argArr = argList.toArray()



    privateMethod?.let {
        return it.call(*argArr)
    }

    throw NoSuchMethodException("Method $methodName does not exist in ${objectInstance::class.qualifiedName}")

}