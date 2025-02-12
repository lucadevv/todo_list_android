package com.lucadev.todolist.app.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucadev.todolist.app.data.local.entity.Category
import com.lucadev.todolist.app.use_case.CategoryUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel(private val categoryUseCase: CategoryUseCase): ViewModel(){

    private val _categoryList:MutableStateFlow<List<Category>> = MutableStateFlow<List<Category>>(emptyList())
     val categoryList:StateFlow<List<Category>> = _categoryList.asStateFlow()

    private val _isLoading = MutableStateFlow(true)  // Estado de carga
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()


    init{
        getAllCategories()
    }

    private fun getAllCategories(){
        viewModelScope.launch {
            _isLoading.value = true
            categoryUseCase.getAllCategories()
                .collect { categoryList ->
                    _categoryList.value = categoryList;
                    _isLoading.value = false
                }
        }
    }





}