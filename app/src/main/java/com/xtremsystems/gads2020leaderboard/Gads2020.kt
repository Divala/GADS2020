package com.xtremsystems.gads2020leaderboard

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Gads2020 : Application() {
    companion object {
        var service: Gads2020Service? = null
        var submitService: SubmitService? = null

    }

    override fun onCreate() {
        super.onCreate()

        service = Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Gads2020Service::class.java)

        submitService = Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SubmitService::class.java)


    }
}