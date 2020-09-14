package com.aibles.zulipeventtest.di

import com.aibles.zulipeventtest.MessageViewModel
import com.aibles.zulipeventtest.api.EventResource
import com.aibles.zulipeventtest.api.MessageResource
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModule = module {
    factory { MessageViewModel(get(), get(), get()) }
    factory { get<Retrofit>().create(EventResource::class.java) }
    factory { get<Retrofit>().create(MessageResource::class.java) }
}