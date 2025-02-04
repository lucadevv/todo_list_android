package com.lucadev.todolist.app.screens.ui_entity


import androidx.compose.ui.graphics.Color
import com.lucadev.todolist.R

data class CategoryEntity(val icon:Int, val count:String,val title:String, val color: Color)


val  listHeaderItems = listOf(
    CategoryEntity(icon = R.drawable.heart, count = "20", title = "Health", color = Color(0XFF7990F8)),
    CategoryEntity(icon = R.drawable.table, count = "30", title = "Work", color = Color(0XFF46CF8B)),
    CategoryEntity(icon = R.drawable.mental, count = "24", title = "Mental", color = Color(0XFFBC5EAD)),
    CategoryEntity(icon = R.drawable.others, count = "2", title = "Others", color = Color(0XFF908986)),
)

