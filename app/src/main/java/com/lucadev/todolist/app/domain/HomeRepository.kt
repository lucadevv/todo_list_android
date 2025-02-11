package com.lucadev.todolist.app.domain

import com.lucadev.todolist.app.data.local.entity.Category
import kotlinx.coroutines.flow.Flow


interface  HomeRepository{
    suspend fun insertCategories(category: Category);
    fun getAllCategories(): Flow<List<Category>>;
}