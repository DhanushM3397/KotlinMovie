package com.example.newsapp.api

import com.example.newsapp.modelClass.episode_information.RootOFEpisodes
import com.example.newsapp.modelClass.JsonRootclass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface newsApi {
    @GET("most-popular/")
suspend fun  getNewsInfo(@Query("page") page: Int) :Response<JsonRootclass>?


@GET(("show-details/"))
 suspend fun getEpisodeInfo(@Query("q") id: String):Response<RootOFEpisodes>

 @GET("search/")
 suspend fun  getsearchView(@Query("q") query: String,@Query("page") page: Int ) :Response<JsonRootclass>?
}