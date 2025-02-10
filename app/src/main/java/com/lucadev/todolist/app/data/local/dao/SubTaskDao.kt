package com.lucadev.todolist.app.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import com.lucadev.todolist.app.data.local.entity.SubTask

interface SubTaskDao {

    @Insert
    suspend fun insertSubTask(subTask: SubTask)
    @Query("SELECT * FROM sub_tasks")
    suspend fun getAllSubTask()
}