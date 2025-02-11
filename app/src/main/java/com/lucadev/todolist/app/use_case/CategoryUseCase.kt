package com.lucadev.todolist.app.use_case

import com.lucadev.todolist.app.data.local.entity.Category
import com.lucadev.todolist.app.domain.CategoryRepository
import kotlinx.coroutines.flow.Flow


class CategoryUseCase(private val categoryRepository: CategoryRepository ){

    fun getAllCategories( ):Flow<List<Category>>{
        return  categoryRepository.getAllCategories();
    }
    suspend fun insertCategory( category: Category){
        categoryRepository.insertCategories(category);
    }
}