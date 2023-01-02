package com.cgnu.sdk.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.observe(
    scope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    crossinline onChanged: (T) -> Unit
) {
    val flow = this
    scope.launch {
        flow.collect {
            it?.let {
                onChanged(it)
            }
        }
    }
}