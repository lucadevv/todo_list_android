package com.lucadev.todolist.app.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            entity = Categories::class,
            parentColumns = ["idCategory"],
            childColumns = ["idCategory"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val idTask:Int = 0,
    val nameTask:String,
    val state:Boolean=false,
    val idCategory:Int,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    val createAt:String=""
    )

