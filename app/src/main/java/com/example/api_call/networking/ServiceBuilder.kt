package com.example.api_call.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {


    fun makeRetrofitService() : ConnectionEndPoint {
        return Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ConnectionEndPoint::class.java)
    }
}