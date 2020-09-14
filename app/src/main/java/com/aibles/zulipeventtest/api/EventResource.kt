package com.aibles.zulipeventtest.api

import com.aibles.zulipeventtest.EventRegister
import com.aibles.zulipeventtest.EventRegisterResponse
import com.aibles.zulipeventtest.EventResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EventResource {
    @POST("/registers")
    suspend fun registerEventQueue(@Body eventRegister: EventRegister): Call<EventRegisterResponse>

    @GET("/events")
    suspend fun getEvent(@Query("queue_id") queueId: String,
                    @Query("last_event_id") lastEventId: Long): Response<EventResponse>

}