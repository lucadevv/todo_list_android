package com.lucadev.todolist.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "categories",
)
data class Categories(
    @PrimaryKey(autoGenerate = true)
    val idCategory:Int = 0,
    val nameCategory: String,
    )
