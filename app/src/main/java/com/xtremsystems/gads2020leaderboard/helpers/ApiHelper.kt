package com.xtremsystems.gads2020leaderboard.helpers

import com.xtremsystems.gads2020leaderboard.Gads2020
import com.xtremsystems.gads2020leaderboard.data.LearnerHours
import com.xtremsystems.gads2020leaderboard.data.LearnerSkills
import retrofit2.Response

object ApiHelper {

    private suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {

        return try {

            val myResp = call.invoke()

            when {
                myResp.isSuccessful -> {
                    ApiResult.Success(myResp.body()!!)
                }

                myResp.code() == 500 -> {

                    ApiResult.Error("System internal error")

                }
                else -> {
                    ApiResult.Error(
                        "Something went wrong. Try again later"
                    )
                }
            }


        } catch (e: Exception) {

            ApiResult.Error(e.message ?: "No internet connection")
        }
    }

    suspend fun getLearnerHours(): ApiResult<LearnerHours> {
        return safeApiCall { Gads2020.service?.getLearnerHours()!! }
    }

    suspend fun getLearnerSkills(): ApiResult<LearnerSkills> {
        return safeApiCall { Gads2020.service?.getLearnerSkills()!! }
    }

    suspend fun submitProject(
        firstName: String,
        surname: String,
        email: String,
        link: String
    ): ApiResult<Any> {
        return safeApiCall {
            Gads2020.submitService?.submitProject(
                firstName,
                surname,
                email,
                link
            )!!
        }
    }
}