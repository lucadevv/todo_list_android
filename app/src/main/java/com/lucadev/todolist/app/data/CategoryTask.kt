package com.lucadev.todolist.app.data

data class CategoryTask(val id:Int,val name:String, val listTask: List<Task> = emptyList())




val categoryTask: List<CategoryTask> = mutableListOf(
    CategoryTask(0,"Health", emptyList()),
    CategoryTask(1,"Work", emptyList()),
    CategoryTask(2,"Mental Health", emptyList()),
    CategoryTask(3,"Others", emptyList()),
)