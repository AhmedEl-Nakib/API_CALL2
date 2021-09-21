package com.example.api_call

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api_call.networking.Article
import com.example.api_call.networking.NewsResponse
import com.example.api_call.networking.ServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var newsList = MutableLiveData<List<Article>>()

    fun getDataFromServer() {

        ServiceBuilder.makeRetrofitService().getBitCoinData("bitcoin", "f84e82f13dc1416582f2e62c73580ba3").enqueue(object :Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                newsList.value = response.body()!!.articles
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }

        })

    }
}