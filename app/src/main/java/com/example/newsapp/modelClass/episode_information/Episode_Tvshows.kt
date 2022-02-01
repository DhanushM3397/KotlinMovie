package com.example.newsapp.modelClass.episode_information


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodetvshow")
data class Episode_Tvshows(
    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String,

    @ColumnInfo(name = "url")
    @SerializedName("url")
    var url: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String,

    @ColumnInfo(name = "start_date")
    @SerializedName("start_date")
    var start_date: String,

    @ColumnInfo(name = "country")
    @SerializedName("country")
    var country: String,
    @ColumnInfo(name = "image_thumbnail_path")
    @SerializedName("image_thumbnail_path")
    var image_thumbnail_path: String,

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    var rating: String,


    /*@ColumnInfo(name = "network")
    @SerializedName("network")
    var network: String,*/

    /*@ColumnInfo(name = "genres")
    @SerializedName("genres")
    var genres: List<String>,

    @ColumnInfo(name = "pictures")
    @SerializedName("pictures")
    var pictures: List<String>,

 @ColumnInfo(name = "episodes")
    @SerializedName("episodes")
    var episodes: List<Episodes>*/


) {
}