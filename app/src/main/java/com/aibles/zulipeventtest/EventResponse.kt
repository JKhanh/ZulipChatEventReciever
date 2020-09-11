package com.aibles.zulipeventtest

import com.google.gson.annotations.SerializedName
import java.util.*

data class EventResponse(
    var result: String,
    var msg: String?,
    @SerializedName("events") var events: List<Objects>?,
    var type: String,
    @SerializedName("queue_id") var queueId: String
) {
}