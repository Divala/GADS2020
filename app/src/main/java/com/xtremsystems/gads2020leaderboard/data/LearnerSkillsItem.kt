package com.xtremsystems.gads2020leaderboard.data


import com.google.gson.annotations.SerializedName

data class LearnerSkillsItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int
)