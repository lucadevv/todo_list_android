package com.lucadev.todolist.app.data

data class CategoryTask(val id:Int,val name:String, val listTask: List<Task> = emptyList())




val categoryTask: List<CategoryTask> = listOf(
    CategoryTask(0,"Health",),
    CategoryTask(1,"Work",),
    CategoryTask(2,"Mental Health", listOf(
        Task(id = 0, taskName = "Meditar",  idCategory = 2)
    )),
    CategoryTask(3,"Others",),
)