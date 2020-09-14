package com.aibles.zulipeventtest

import android.app.Application
import com.aibles.zulipeventtest.di.createRemoteModule
import com.aibles.zulipeventtest.di.utilsFeature
import com.aibles.zulipeventtest.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZulipApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@ZulipApplication)
            val modules = modules(
                listOf(
                    utilsFeature,
                    viewModule,
                    createRemoteModule("https://zulip-dev.aibles.com/api/v1/")
                )
            )
        }
    }
}