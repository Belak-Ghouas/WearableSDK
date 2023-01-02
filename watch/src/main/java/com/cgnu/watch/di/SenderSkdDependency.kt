package com.cgnu.watch.di

import com.cgnu.sdk.framework.*
import com.cgnu.sdk.util.Config
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
        return "/from_watch"
    }
}

val senderDependency = module {
    single <Config>{ ConfigImpl }
    single <ISender> { Sender(context = get(), config = get())  }
    single <SenderDataSource> {SenderDataSourceImpl(sender = get())    }
    single <SenderRepository>{SenderRepositoryImpl(senderDataSource = get())  }

}