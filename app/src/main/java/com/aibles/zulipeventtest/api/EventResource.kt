package com.aibles.zulipeventtest.api

import com.aibles.zulipeventtest.EventRegister
import com.aibles.zulipeventtest.MessageEvent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface EventResource {
    @POST("/registers")
    fun registerEventQueue(eventRegister: EventRegister): okhttp3.Response

    @GET("/events")
    fun getEvent(): Response<List<MessageEvent>>

}