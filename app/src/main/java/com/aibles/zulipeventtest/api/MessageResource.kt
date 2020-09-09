package com.aibles.zulipeventtest.api

import com.aibles.zulipeventtest.MessageResponse
import retrofit2.Response
import retrofit2.http.GET

interface MessageResource {
    @GET("/message")
    fun getMessage(): Response<List<MessageResponse>>
}