package com.aibles.zulipeventtest

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("avatar_url") var avatarUrl: String,
    var client: String,
    var content: String,
    @SerializedName("display_recipient") var displayRecipient: List<DisplayRecipient>,
    var id: Long,
    @SerializedName("content_type") var contentType: String,
    @SerializedName("is_me_message") var isMeMessage: Boolean,
    @SerializedName("recipient_id") var recipientId: Long,
    @SerializedName("sender_email") var senderEmail: String,
    @SerializedName("sender_fullname") var senderFullName: String,
    @SerializedName("sender_id") var senderId: Long,
    @SerializedName("sender_realm") var senderRealm: String,
    @SerializedName("stream_id") var streamId: Long,
    var subject: String,
    @SerializedName("topic_link") var topicLink: String?,
    @SerializedName("submessage") var subMessage: String?,
    var timestamp: Long,
    var type: String,
    var flags: String,
    @SerializedName("last_edit_timestamp") var lastEditTimestamp: Long,
    @SerializedName("match_content") var matchContent: String,
    @SerializedName("match_subject") var matchSubject: String
) {
}