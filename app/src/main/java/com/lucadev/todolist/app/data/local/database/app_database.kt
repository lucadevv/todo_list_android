package com.lucadev.todolist.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucadev.todolist.app.data.local.dao.CategoryDao
import com.lucadev.todolist.app.data.local.dao.SubTaskDao
import com.lucadev.todolist.app.data.local.dao.TaskDao
import com.lucadev.todolist.app.data.local.entity.Category
import com.lucadev.todolist.app.data.local.entity.SubTask
import com.lucadev.todolist.app.data.local.entity.Task


@Database(entities = [Category::class, Task::class, SubTask::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun categoryDao(): CategoryDao
    abstract fun taskDao(): TaskDao
    abstract fun subTaskDao(): SubTaskDao
    companion object
}