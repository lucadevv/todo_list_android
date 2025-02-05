package com.lucadev.todolist.app.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucadev.todolist.app.data.CategoryTask
import com.lucadev.todolist.app.data.categoryTask
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel(){

    private val _listCategory = MutableStateFlow<List<CategoryTask>>(categoryTask)
    val listCategory: StateFlow<List<CategoryTask>>  = _listCategory
    private  val _isLoading = MutableStateFlow<Boolean>(false);
    val isLoading = _isLoading;

    init{
        getAllCategories()
    }

    private fun getAllCategories(){
        viewModelScope.launch {
            _isLoading.value = true;
            delay(timeMillis = 4000)
            _listCategory.value = categoryTask
            _isLoading.value = false;
        }
    }


}