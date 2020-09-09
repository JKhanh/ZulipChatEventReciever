package com.aibles.zulipeventtest.di

import com.aibles.zulipeventtest.api.AuthInterceptor
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

fun createRemoteModule(baseUrl: String) = module {
    factory {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    factory { AuthInterceptor() }

    factory {
        Gson()
            .newBuilder()
            .serializeNulls()
            .create()
    }


    factory {
        OkHttpClient.Builder().addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<AuthInterceptor>()).build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}