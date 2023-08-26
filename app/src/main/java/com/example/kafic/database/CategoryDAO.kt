package com.example.kafic.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction as Transaction

@Dao
interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Transaction
    @Query("SELECT * FROM category WHERE categoryName = :categoryName")
    suspend fun getCategoryAndItem(categoryName: String) : List<CategoryAndItem>
}