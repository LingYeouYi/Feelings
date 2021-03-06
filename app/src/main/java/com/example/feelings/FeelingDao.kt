package com.example.feelings

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeelingDao {
    @Insert
    suspend fun insertFeeling(feeling: Feeling)

    @Query("SELECT * FROM feeling")
    fun getFeelings() : LiveData<List<Feeling>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(feeling: Feeling)

    @Query("DELETE FROM feeling")
    suspend fun deleteAll()

}