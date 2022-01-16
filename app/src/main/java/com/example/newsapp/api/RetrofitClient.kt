package com.example.newsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val BASE_URL = "https://www.episodate.com/api/"
    private val EPISODE_URL="https://www.episodate.com/api/"

    open fun getNewsInformation(): newsApi {
        return Retrofit.Builder().
        baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).
            build().
            create(newsApi::class.java)
    }


}