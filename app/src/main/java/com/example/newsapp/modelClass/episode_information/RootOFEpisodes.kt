package com.example.newsapp.modelClass.episode_information

import com.google.gson.annotations.SerializedName


data class RootOFEpisodes(

    @SerializedName("tvShow")
    val ep_tvShows: Episode_Tvshows) {

}


