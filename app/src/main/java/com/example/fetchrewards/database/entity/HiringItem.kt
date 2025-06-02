package com.example.fetchrewards.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "hiring_item"
)
data class HiringItem(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "list_id")
    val listId: Int,
    @ColumnInfo(name = "name")
    val name: String
)
