package com.lucadev.todolist.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucadev.todolist.ui.theme.TodolistTheme


@Composable
fun HomeScreen(modifier: Modifier){
    Column(
    modifier = modifier
        .padding(horizontal = 16.dp),
    ) {
        Text("TODAY 03 FEB")
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(4){
                Card(
                    onClick = {},
                    modifier = Modifier
                        .height(98.dp)
                ) { }
            }
        }
    }
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
