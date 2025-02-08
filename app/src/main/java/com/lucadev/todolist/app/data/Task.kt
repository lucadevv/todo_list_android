package com.lucadev.todolist.app.data

data class Task(
    val taskName:String,
    val state:Boolean = false,
    val listSubTask: MutableList<SubTask> = mutableListOf()
)

val listTask = mutableListOf(
    Task( taskName = "Codear en android", state = true, listSubTask = mutableListOf(
        SubTask(nameSubTask = "Aprender kotlin", stateSubtask = true),
        SubTask(nameSubTask = "Aprender JetpackCompose", stateSubtask = true),
    )),
    Task( taskName = "Aprender Trading", state = false),
)
