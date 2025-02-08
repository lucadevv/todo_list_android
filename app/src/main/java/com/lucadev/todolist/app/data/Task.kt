package com.lucadev.todolist.app.data

data class Task(
    val id: Int,
    val taskName:String,
    val state:Boolean = false,
    val idCategory:Int,
    val listSubTask:List<SubTask> = emptyList()
)


val listTask = mutableListOf(
    Task(id = 0, taskName = "Codear en android", state = true, idCategory = 0, emptyList()),
    Task(id = 1, taskName = "Aprender Trading", state = false, idCategory = 1, emptyList()),
)
