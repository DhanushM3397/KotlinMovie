package com.example.newsapp.DaoDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.modelClass.episode_information.Episode_Tvshows

@Database(entities = [EpisodeEntiity::class], version = 2)
abstract class RoomSingleton :RoomDatabase (){
    abstract fun userdao() :UsersDao
      companion object{
          private var INSTANCE: RoomSingleton? = null

          fun getInstance(context: Context): RoomSingleton {
              if (INSTANCE == null) {
                  INSTANCE = Room.databaseBuilder(
                      context,
                      RoomSingleton::class.java,
                      "roomdb")
                      .build()
              }
              return INSTANCE as RoomSingleton
          }
      }
}