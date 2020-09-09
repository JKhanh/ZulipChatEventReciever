package com.aibles.zulipeventtest

import com.google.gson.annotations.SerializedName

data class EventRegisterResponse(
    var result: String,
    var msg: String,
    @SerializedName("queue_id") var queueId: String,
    @SerializedName("zulip_version") var zulipVersion: String,
    @SerializedName("zulip_feature_level") var zulipFeatureLevel: Int,
    @SerializedName("max_message_id") var maxMessageId: Long,
    @SerializedName("last_event_id") var lastEventId: Int
)