package com.example.newsapp.DaoDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.security.AlgorithmParameterGeneratorSpi


@Entity(tableName = "episodetvshow")
data class EpisodeEntiity(

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

   @ColumnInfo(name = "genres")
    @SerializedName("genres")
    var genres: String,

    @ColumnInfo(name = "network")
    @SerializedName("network")
    var network: String,

   @ColumnInfo(name = "season")
    @SerializedName("season")
    var season: String,

    @ColumnInfo(name = "air_date")
    @SerializedName("air_date")
    var air_date: String
) {

}