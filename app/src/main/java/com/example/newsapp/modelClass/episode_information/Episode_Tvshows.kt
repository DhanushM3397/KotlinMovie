package com.example.newsapp.modelClass.episode_information

import com.google.gson.annotations.SerializedName


data class Episode_Tvshows(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,


    @SerializedName("url")
    var url: String,



    @SerializedName("description")
    var description: String,


    @SerializedName("start_date")
    var start_date: String,


    @SerializedName("country")
    var country: String,

    @SerializedName("image_thumbnail_path")
    var image_thumbnail_path: String,


    @SerializedName("rating")
    var rating: String,



    @SerializedName("network")
    var network: String,


   /* @SerializedName("genres")
    var genres: List<String>,


    @SerializedName("pictures")
    var pictures: List<String>,


    @SerializedName("episodes")
    var episodes: List<Episodes>*/


) {
}