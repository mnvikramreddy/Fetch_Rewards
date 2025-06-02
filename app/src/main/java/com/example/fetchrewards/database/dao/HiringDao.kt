package com.example.fetchrewards.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fetchrewards.database.entity.HiringItem

@Dao
interface HiringDao {

    @Query("SELECT * From hiring_item")
    suspend fun getHiringList(): List<HiringItem>

    @Insert
    suspend fun insertHiringList(hiringItem: List<HiringItem>)

}