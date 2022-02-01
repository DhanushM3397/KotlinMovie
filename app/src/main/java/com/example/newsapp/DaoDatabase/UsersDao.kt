package com.example.newsapp.DaoDatabase


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(student:EpisodeEntiity)

 @Query("DELETE FROM episodetvshow")
     fun clear()




    @Query("SELECT * FROM episodetvshow ORDER BY id DESC")
    fun allEmplyees(): LiveData<List<EpisodeEntiity>>
}