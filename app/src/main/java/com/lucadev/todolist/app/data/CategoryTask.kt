package com.lucadev.todolist.app.data

data class CategoryTask(val name:String, val listTask: MutableList<Task> = mutableListOf())




val categoryTask: List<CategoryTask> = mutableListOf(
    CategoryTask("Health",listTask),
    CategoryTask("Work",),
    CategoryTask("Mental Health"),
    CategoryTask("Others"),
)

