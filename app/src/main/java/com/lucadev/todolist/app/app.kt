package com.lucadev.todolist.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lucadev.todolist.app.screens.HomeScreen
import com.lucadev.todolist.ui.theme.TodolistTheme


@Composable
fun App(){
    TodolistTheme {
        Scaffold { innerPadding ->
            HomeScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}