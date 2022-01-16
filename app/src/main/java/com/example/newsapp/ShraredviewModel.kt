package com.example.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.modelClass.Tv_shows

open class SharedViewModel : ViewModel() {


        var dataPassingList = MutableLiveData<List<Tv_shows>>()


    fun SharedValue(string: List<Tv_shows>) {

        dataPassingList.value = string
    }

}