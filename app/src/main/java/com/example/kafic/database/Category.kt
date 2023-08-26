package com.example.kafic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "categoryName")
    val categoryName : String
)
