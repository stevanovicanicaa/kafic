package com.example.kafic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Category::class, Item::class], version = 1)
abstract class CategoryDatabase : RoomDatabase()
{
     abstract val categoryDao: CategoryDAO

     companion object{
         @Volatile
         private var INSTANCE : CategoryDatabase? = null

         fun getInstance(context: Context): CategoryDatabase{
             synchronized(this){
                 return INSTANCE ?: Room.databaseBuilder(
                     context.applicationContext,
                     CategoryDatabase::class.java,
                     "category_db"
                 ).build().also {
                     INSTANCE = it
                 }
             }
         }
     }
}