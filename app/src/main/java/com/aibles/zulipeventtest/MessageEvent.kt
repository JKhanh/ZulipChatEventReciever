package com.aibles.zulipeventtest

import com.google.gson.annotations.SerializedName

data class MessageEvent(
    var result: String,
    var msg: String?,
    @SerializedName("events") var messages: MessageResponse?,
    @SerializedName("queue_id") var queueId: String,
)