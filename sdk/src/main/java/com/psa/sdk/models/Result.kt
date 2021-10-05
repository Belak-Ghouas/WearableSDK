package com.psa.sdk.models


sealed class Result<out T> {

    data class Success<out T>(val value: T): Result<T>()
    data class Failure<T>(
        val message: String?,
        val throwable: Throwable?
    ): Result<T>()

    class Cancelled<T> : Result<T>()
    class Unknown<T> : Result<T>()


    inline fun <M> transform(process: (T) -> M): Result<M> = when (this) {
        is Success -> Success(process(this.value))
        is Failure -> Failure(message,throwable)
        is Cancelled -> Cancelled()
        is Unknown -> Unknown()
    }

}

inline fun <reified T> Result<T>.doIfFailure(callback: (error: String?, throwable: Throwable?) -> Unit) {
    if (this is Result.Failure) {
        callback(message, throwable)
    }
}

inline fun <reified T> Result<T>.doIfSuccess(callback: (value: T) -> Unit) {
    if (this is Result.Success) {
        callback(value)
    }
}

