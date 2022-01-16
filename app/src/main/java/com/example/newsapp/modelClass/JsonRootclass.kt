package com.example.newsapp.modelClass



data class JsonRootclass(
    val total:String,
    val page: Int,
    val pages:Int,
    val tv_shows:List<Tv_shows>
) {
}

