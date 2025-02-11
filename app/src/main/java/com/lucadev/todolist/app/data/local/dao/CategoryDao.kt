package com.lucadev.todolist.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lucadev.todolist.app.data.local.entity.Category
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {
    @Insert
    suspend fun insertCategory(categories: Category)
    @Query("SELECT * FROM categories")
     fun getAllCategories(): Flow<List<Category>>
}