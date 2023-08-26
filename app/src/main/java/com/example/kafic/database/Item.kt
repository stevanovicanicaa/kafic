package com.example.kafic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "item") val item: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "categoryName") val categoryName: String
)
