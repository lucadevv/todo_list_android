package com.lucadev.todolist.app.data

data class SubTask(val id:Int,val nameSubTask:String,val stateSubtask:Boolean = false, val idTask: Int);





val listSubTask = listOf(
    SubTask(idTask = 0, nameSubTask = "hola", stateSubtask = false, id = 2),
    SubTask(idTask = 0, nameSubTask = "hola", stateSubtask = false, id = 2),
    SubTask(idTask = 0, nameSubTask = "hola", stateSubtask = false, id = 2),
    SubTask(idTask = 0, nameSubTask = "hola", stateSubtask = false, id = 2),
)