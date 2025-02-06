package com.lucadev.todolist.app.data

data class Task(
    val id: Int,
    val taskName:String,
    val state:Boolean = false,
    val idCategory:Int,
    val listSubTask:List<SubTask> = emptyList()
)


val listTask = listOf(
    Task(id = 1, taskName = "hola", state = false, idCategory = 2, listSubTask = emptyList()),
    Task(id = 1, taskName = "hola", state = false, idCategory = 2, listSubTask = emptyList()),
    Task(id = 1, taskName = "hola", state = false, idCategory = 2, listSubTask = emptyList()),
    Task(id = 1, taskName = "hola", state = false, idCategory = 2, listSubTask = emptyList()),
)

