package com.lucadev.todolist.app.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucadev.todolist.app.data.CategoryTask
import com.lucadev.todolist.app.data.Task
import com.lucadev.todolist.app.data.categoryTask
import com.lucadev.todolist.app.data.listTask
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel(){

    private val _listCategory = MutableStateFlow<List<CategoryTask>>(emptyList())
    val listCategory: StateFlow<List<CategoryTask>>  = _listCategory
    private  val _isLoading = MutableStateFlow<Boolean>(false);
    val isLoading = _isLoading;

    private val _listTask = MutableStateFlow<List<Task>>(emptyList())
    val listTaskData:StateFlow<List<Task>> = _listTask
    private val _isLoadingListTask = MutableStateFlow<Boolean>(value = false)
    val isLoadingListTask: StateFlow<Boolean> = _isLoadingListTask

    init{
        getAllCategories()
        getAllTask()
    }

    private fun getAllCategories(){
        viewModelScope.launch {
            _isLoading.value = true;
            delay(timeMillis = 4000)
            _listCategory.value = categoryTask
            _isLoading.value = false;
        }
    }

    private fun getAllTask(){
        viewModelScope.launch {
            _isLoadingListTask.value = true
//            delay(timeMillis = 4000)
            _listTask.value = listTask
            _isLoadingListTask.value = false
        }
    }




}