

package com.cgnu.watch

import android.app.Application
import com.cgnu.watch.di.senderDependency
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.ERROR

/**
 * Base class for maintaining global application state.
 */
class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(ERROR)
            // Android context
            androidContext(this@SampleApp)
        }
        loadKoinModules(listOf(senderDependency))
    }

}
