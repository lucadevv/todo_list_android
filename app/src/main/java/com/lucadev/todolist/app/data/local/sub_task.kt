package com.lucadev.todolist.app.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "sub_tasks",
    foreignKeys = [
        ForeignKey(
            entity = Task::class,
            parentColumns = ["idTask"],
            childColumns = ["idTask"],
        )
    ]
)
data class SubTasks(
    @PrimaryKey(autoGenerate = true)
    val idSutTask:Int = 0,
    val name:String,
    val state:Boolean = false,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    val createAt:String="",
    val idTask:Int
)