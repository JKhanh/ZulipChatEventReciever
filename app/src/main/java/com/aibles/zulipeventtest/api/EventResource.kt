package com.aibles.zulipeventtest.api

import com.aibles.zulipeventtest.EventRegister
import com.aibles.zulipeventtest.EventRegisterResponse
import com.aibles.zulipeventtest.EventResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface EventResource {
    @POST("/registers")
    fun registerEventQueue(eventRegister: EventRegister): Response<EventRegisterResponse>

    @GET("/events")
    fun getEvent(): Response<EventResponse>

}