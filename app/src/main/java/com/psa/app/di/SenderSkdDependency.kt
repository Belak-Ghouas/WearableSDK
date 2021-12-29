package com.psa.app.di

import com.psa.sdk.send.*
import com.psa.sdk.util.Config
import org.koin.dsl.module

/**
 * @author Abdelhak GHOUAS
 * @email : abdelhak.ghouas@capgemini.com
 * Created 29/12/2021
 */

object ConfigImpl :Config{
    override fun getCapability(): String {
        return  "messages"
    }

    override fun getMessageRoute(): String {
        return "/messages"
    }

    override fun getDataPrefixPath(): String {
        return "/from_phone"
    }
}
val NetworkDependency = module {
    single <Config>{ConfigImpl }
    single<SenderDataSource> {SenderDataSourceImpl(context = get(), config = get())    }
    single <SenderRepository>{SenderRepositoryImpl(senderDataSource = get())  }
    single { SendMessageUseCase(senderRepository = get()) }
}