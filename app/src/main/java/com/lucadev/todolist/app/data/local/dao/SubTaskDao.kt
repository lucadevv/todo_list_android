package com.lucadev.todolist.app.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import com.lucadev.todolist.app.data.local.entity.SubTask
import kotlinx.coroutines.flow.Flow

interface SubTaskDao {

    @Insert
    suspend fun insertSubTask(subTask: SubTask)
    @Query("SELECT * FROM sub_tasks")
    fun getAllSubTask(): Flow<List<SubTask>>
}