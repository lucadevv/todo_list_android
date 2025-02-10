package com.lucadev.todolist.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Categories::class,Task::class,SubTasks::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    companion object
}