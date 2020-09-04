package com.aibles.zulipeventtest.api

import retrofit2.http.GET

interface MessageResource {
    @GET
    fun getMessage()
}