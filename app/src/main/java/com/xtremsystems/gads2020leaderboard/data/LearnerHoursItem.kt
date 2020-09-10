package com.xtremsystems.gads2020leaderboard.data


import com.google.gson.annotations.SerializedName

data class LearnerHoursItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("name")
    val name: String
)