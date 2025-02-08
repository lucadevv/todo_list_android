package com.lucadev.todolist.app
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucadev.todolist.app.screens.AddScreen
import com.lucadev.todolist.app.screens.HomeScreen
import com.lucadev.todolist.app.screens.viewmodel.HomeViewModel
import com.lucadev.todolist.ui.theme.TodolistTheme


@Composable
fun App(
    homeViewModel: HomeViewModel
){
    TodolistTheme {
        NavigationApp(homeViewModel = homeViewModel)
    }
}


@Composable
fun NavigationApp(homeViewModel: HomeViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }
        composable("add"){
            AddScreen(navController = navController)
        }

    }
}