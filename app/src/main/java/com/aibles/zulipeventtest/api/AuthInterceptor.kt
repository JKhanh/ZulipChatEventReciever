package com.aibles.zulipeventtest.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {

    val credential = Credentials.basic("iago@zulip.com", "KNNvCzH1BOb9nEbSZ20bAlwjOxCpGu2Z")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticateRequest = request.newBuilder()
            .addHeader("Authorization", credential).build()
        return chain.proceed(authenticateRequest)
    }
}