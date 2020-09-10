package com.xtremsystems.gads2020leaderboard

import com.xtremsystems.gads2020leaderboard.data.LearnerHours
import com.xtremsystems.gads2020leaderboard.data.LearnerSkills
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface Gads2020Service {
    @GET("hours")
    suspend fun getLearnerHours(): Response<LearnerHours>

    @GET("skilliq")
    suspend fun getLearnerSkills(): Response<LearnerSkills>

}
