package com.lucadev.todolist.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "categories",
)
data class Category(
    @PrimaryKey(autoGenerate = true)
    val idCategory:Int = 0,
    val nameCategory: String,
    )
