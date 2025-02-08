package com.lucadev.todolist.app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucadev.todolist.R
import com.lucadev.todolist.app.screens.ui_entity.listHeaderItems
import com.lucadev.todolist.app.screens.viewmodel.HomeViewModel
import com.lucadev.todolist.ui.theme.TodolistTheme


@Composable
fun HomeScreen(
    modifier: Modifier,
    homeViewModel: HomeViewModel,
    ) {
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
        Header(homeViewModel = homeViewModel)
        ListTasks(homeViewModel= homeViewModel)

    }

}


@Composable
private fun Header(
    homeViewModel: HomeViewModel
){
    val listCategory by homeViewModel.listCategory.collectAsState()
    val isLoadingCategory by homeViewModel.isLoading.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        itemsIndexed(listHeaderItems) { index, item ->
            val lengthTask = listCategory.getOrNull(index)?.listTask?.size ?: 0
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
                        if (!isLoadingCategory) {
                            Text(lengthTask.toString())
                        } else {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(25.dp)
                            )
                        }
                        Text(item.title)
                    }

                }
            }
        }

    }
}

@Composable
private fun ListTasks(
    homeViewModel: HomeViewModel
){
    val listTask by homeViewModel.listTaskData.collectAsState()
    val isLoading by homeViewModel.isLoadingListTask.collectAsState()
    val arrowDown = remember { mutableStateListOf<Boolean>().apply { addAll(List(listTask.size) { false }) } }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(listTask){index,item->
            Card(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0XFF908986).copy(alpha = 0.0f))

            ) {
                ListItem(
                    headlineContent = {
                        Text(item.taskName)
                    },
                    leadingContent = {
                        Checkbox(checked = item.state, onCheckedChange = {})
                    },
                    trailingContent = {
                        IconButton(onClick = {
                            arrowDown[index] = !arrowDown[index]
                        }) {
                            Icon(
                                imageVector = if (arrowDown[index]) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                                contentDescription = "Arrow Toggle"
                            )
                        }
                    }

                )
                if (arrowDown[index]) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp) // Desplazar un poco hacia la derecha
                    ) {
                        ListItem(
                            headlineContent = { Text("subTask.name") },
                            leadingContent = {
                                Checkbox(checked = true, onCheckedChange = {})
                            }
                        )
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
