package com.xtremsystems.gads2020leaderboard

import android.app.Application
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.logging.Level


class Gads2020 : Application() {
    companion object {
        var service: Gads2020Service? = null
        var submitService: SubmitService? = null

    }

    override fun onCreate() {
        super.onCreate()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        service = Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Gads2020Service::class.java)

        submitService = Retrofit.Builder()
            .client(client)
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(SubmitService::class.java)


    }
}