package com.example.newsapp.modelClass.episode_information

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Episodes(
    @ColumnInfo(name="season")
    @SerializedName("season")
    var season: String,

    @ColumnInfo(name="episode")
    @SerializedName("episode")
    var episode: String,

    @ColumnInfo(name="name")
    @SerializedName("name")
    var name: String,

    @ColumnInfo(name="air_date")
    @SerializedName("air_date")
    var air_date: String
) {

}
