package com.example.newsapp.DaoDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.modelClass.episode_information.Episode_Tvshows

@Dao
interface UsersDao {
  /*  @Query("SELECT * FROM episodetvshow ")
    fun getStudents(): LiveData<List<Episode_Tvshows>>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: EpisodeEntiity)


    @Query("DELETE FROM episodetvshow")
    fun clear()


    @Query("SELECT * FROM episodetvshow ORDER BY id DESC")
    fun allEmplyees(): LiveData<List<EpisodeEntiity>>

}