package com.aibles.zulipeventtest

import com.google.gson.annotations.SerializedName

data class DisplayRecipient(
    var email: String,
    @SerializedName("full_name") var fullName: String,
    var id: Long,
    @SerializedName("is_mirror_dummy") var isMirrorDummy: Boolean
) {
}