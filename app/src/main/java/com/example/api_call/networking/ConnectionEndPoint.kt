package com.example.api_call.networking

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ConnectionEndPoint {

    @GET("v2/everything")
    fun getBitCoinData(@Query("q") q:String , @Query("apiKey") apiKey:String) : Call<NewsResponse>


}

