package com.lucadev.todolist.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucadev.todolist.app.screens.ui_entity.listHeaderItems
import com.lucadev.todolist.app.screens.viewmodel.HomeViewModel
import com.lucadev.todolist.ui.theme.TodolistTheme


@Composable
fun HomeScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel,
    ){
    val listCategory by homeViewModel.listCategory.collectAsState()
    val isLoadingCategory by homeViewModel.isLoading.collectAsState()

    println("cargado $isLoadingCategory")
    Column(
    modifier = modifier
        .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "TODAY 03 FEB",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold
            )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(listHeaderItems){index,item->
                val lengthTask =listCategory.getOrNull(index)?.listTask?.size ?: 0
                Card(
                    onClick = {},
                    modifier = Modifier
                        .height(98.dp),
                    colors = CardDefaults.cardColors(containerColor = item.color.copy(alpha = 0.1f)),
                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            tint = item.color
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(lengthTask.toString())
//                            if (!isLoadingCategory) {
//                                Text(lengthTask.toString())
//                            } else {
//                                CircularProgressIndicator(
//                                    modifier = Modifier
//                                        .width(25.dp)
//                                        .height(25.dp)
//                                )
//                            }
                            Text(item.title)
                        }

                    }
                }
            }

        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){

    TodolistTheme {

        Scaffold { innerPadding->
            HomeScreen(modifier = Modifier.padding(innerPadding), homeViewModel = HomeViewModel())
        }
    }
}
