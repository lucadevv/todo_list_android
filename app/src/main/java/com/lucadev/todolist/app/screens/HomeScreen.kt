package com.lucadev.todolist.app.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucadev.todolist.ui.theme.TodolistTheme


@Composable
fun HomeScreen(modifier: Modifier){

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    TodolistTheme {
        Scaffold { innerPadding->
            HomeScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
