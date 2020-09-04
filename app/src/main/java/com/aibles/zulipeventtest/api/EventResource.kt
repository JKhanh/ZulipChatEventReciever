package com.aibles.zulipeventtest.api

import retrofit2.http.GET
import retrofit2.http.POST

interface EventResource {
    @POST()
    fun registerEventQueue()

    @GET
    fun getEvent()

}