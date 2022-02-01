package com.example.newsapp.coroutine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.DaoDatabase.RoomSingleton
import com.example.newsapp.modelClass.episode_information.Episode_Tvshows
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Roomviewmodel(application: Application):AndroidViewModel(application) {
    private val db:RoomSingleton = RoomSingleton.getInstance(application)

    internal val students : LiveData<List<Episode_Tvshows>> = db.userdao().getStudents()
    fun insert(student: Episode_Tvshows){
        viewModelScope.launch(Dispatchers.IO) {
            db.userdao().insert(student)
        }
    }

    fun clear(){
        viewModelScope.launch(Dispatchers.IO) {
            db.userdao()
        }
    }


}