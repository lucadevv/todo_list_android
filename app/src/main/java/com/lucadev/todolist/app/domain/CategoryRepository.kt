package com.lucadev.todolist.app.domain

import com.lucadev.todolist.app.data.local.entity.Category
import kotlinx.coroutines.flow.Flow


interface  CategoryRepository{
    fun getAllCategories(): Flow<List<Category>>;
}