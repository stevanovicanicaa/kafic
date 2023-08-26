package com.example.kafic.database

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryAndItem(
    @Embedded val categoryName: Category,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "categoryName"
    )
    val items: List<Item>
)
