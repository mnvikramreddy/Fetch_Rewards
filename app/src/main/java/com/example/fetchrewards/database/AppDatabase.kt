package com.example.fetchrewards.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fetchrewards.database.dao.HiringDao
import com.example.fetchrewards.database.entity.HiringItem

@Database(entities = [HiringItem::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun hiringDao(): HiringDao
}