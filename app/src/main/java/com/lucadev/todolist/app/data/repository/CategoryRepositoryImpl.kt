package com.lucadev.todolist.app.data.repository

import com.lucadev.todolist.app.data.local.dao.CategoryDao
import com.lucadev.todolist.app.data.local.entity.Category
import com.lucadev.todolist.app.domain.CategoryRepository
import kotlinx.coroutines.flow.Flow


class CategoryRepositoryImpl(private val categoryDao: CategoryDao):CategoryRepository{
    override suspend fun insertCategories(category: Category) {
        return categoryDao.insertCategory(category)
    }
    override fun getAllCategories(): Flow<List<Category>> = categoryDao.getAllCategories()

}