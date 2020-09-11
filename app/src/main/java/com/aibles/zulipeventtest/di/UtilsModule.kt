package com.aibles.zulipeventtest.di

import com.aibles.zulipeventtest.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val utilsFeature = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
}