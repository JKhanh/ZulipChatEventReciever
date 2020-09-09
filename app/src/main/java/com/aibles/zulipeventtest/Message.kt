package com.aibles.zulipeventtest

data class Message(
    var avatarUrl: String,
    var client: String,
    var content: String,
    var displayRecipient: List<DisplayRecipient>,
    var id: Long,
    var isMeMessage: Boolean,
    var recipientId: Long,
    var senderEmail: String,
    var senderFullName: String,
    var senderId: Long,
    var senderRealm: String,
    var streamId: Long,
    var subject: String,
    var topicLink: String?,
    var subMessage: String?,
    var timestamp: Long,
    var type: String,
    var flags: String,
    var lastEditTimestamp: Long,
    var matchContent: String,
    var matchSubject: String
) {
}