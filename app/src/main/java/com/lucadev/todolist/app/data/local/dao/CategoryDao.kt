package com.lucadev.todolist.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lucadev.todolist.app.data.local.entity.Category
import kotlinx.coroutines.flow.Flow


@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(categories: List<Category>)
    @Query("SELECT * FROM categories")
     fun getAllCategories(): Flow<List<Category>>
    @Query("SELECT COUNT(*) FROM categories")
    suspend fun countCategories(): Int
}