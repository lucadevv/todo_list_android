package com.lucadev.todolist.app.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucadev.todolist.app.data.CategoryTask
import com.lucadev.todolist.app.data.SubTask
import com.lucadev.todolist.app.data.Task
import com.lucadev.todolist.app.data.categoryTask
import com.lucadev.todolist.app.data.listTask
import com.lucadev.todolist.app.data.local.entity.Category
import com.lucadev.todolist.app.use_case.CategoryUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel(private val categoryUseCase: CategoryUseCase): ViewModel(){

    private val _categoryList:MutableStateFlow<List<Category>> = MutableStateFlow<List<Category>>(emptyList())
    private val categoryList = _categoryList.asStateFlow()

    init{
        getAllCategories()
    }

    private fun getAllCategories(){
        viewModelScope.launch {
            categoryUseCase.getAllCategories()
                .collect { categoryList ->
                    _categoryList.value = categoryList;
                }
        }
    }





}