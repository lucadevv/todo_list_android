package com.lucadev.todolist.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun AddScreen(
    navController: NavController
){
    Scaffold {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))

    }
}