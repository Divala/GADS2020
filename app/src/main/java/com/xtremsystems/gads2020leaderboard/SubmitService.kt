package com.xtremsystems.gads2020leaderboard

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface SubmitService {

    @Headers("Content-Type: application/json")
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun submitProject(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") surname: String,
        @Field("entry.1824927963") email: String,
        @Field("entry.284483984") link: String
    ): Response<Any>
}