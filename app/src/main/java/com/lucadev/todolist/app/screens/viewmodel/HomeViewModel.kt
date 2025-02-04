package com.lucadev.todolist.app.screens.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel: ViewModel(){

    private val _listItem = MutableStateFlow<List<String>>(listOf<String>("Luis","Ivan","carranza"))
    val listItem: StateFlow<List<String>> get()  = _listItem




}