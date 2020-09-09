package com.aibles.zulipeventtest

import com.google.gson.annotations.SerializedName

data class EventRegister(
    @SerializedName("event_types") var eventTypes: String = "message",
    @SerializedName("all_public_stream") var allPublicStream: Boolean,
    var narrow: String?
)