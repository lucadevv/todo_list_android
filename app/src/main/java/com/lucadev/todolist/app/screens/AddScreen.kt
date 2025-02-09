package com.lucadev.todolist.app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lucadev.todolist.ui.theme.TodolistTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    navController: NavController
){
    var textField = remember { mutableStateOf("Codear") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {  },
               navigationIcon = {
                   IconButton(onClick = { navController.popBackStack() }) {
                       Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                   }
               }
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),

                value = textField.value,
                onValueChange = { textField.value = it },
                placeholder = {
                    Text("Escribe tu nueva tarea...",
                        fontSize = 25.sp,
                        )
                },
                textStyle = TextStyle(
                    fontSize = 25.sp
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }


    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddScreenPreview(){
    val navController = rememberNavController()
    TodolistTheme {
        AddScreen(navController = navController)
    }
}