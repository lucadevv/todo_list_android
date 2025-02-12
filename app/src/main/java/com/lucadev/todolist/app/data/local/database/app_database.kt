package com.lucadev.todolist.app.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.lucadev.todolist.app.data.local.dao.CategoryDao
import com.lucadev.todolist.app.data.local.dao.SubTaskDao
import com.lucadev.todolist.app.data.local.dao.TaskDao
import com.lucadev.todolist.app.data.local.entity.Category
import com.lucadev.todolist.app.data.local.entity.SubTask
import com.lucadev.todolist.app.data.local.entity.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Category::class, Task::class, SubTask::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun categoryDao(): CategoryDao
    abstract fun taskDao(): TaskDao
    abstract fun subTaskDao(): SubTaskDao
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
               Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "todo_list_database"
                ).addCallback(databaseCallback)
                   .fallbackToDestructiveMigration()
                   .build()
                   .also { INSTANCE = it }

            }
        }
        // Callback que se ejecuta cuando se crea la base de datos
        private val databaseCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        insertDefaultCategories(database.categoryDao())
                    }
                }
            }
        }
        // Insertar las categorías si no existen
        private suspend fun insertDefaultCategories(categoryDao: CategoryDao) {
            val categories = listOf(
                Category(nameCategory = "Trabajo"),
                Category(nameCategory = "Personal"),
                Category(nameCategory = "Salud"),
                Category(nameCategory = "Otros")
            )

            // Solo inserta si la tabla está vacía
            if (categoryDao.countCategories() == 0) {
                categoryDao.insertAll(categories)
            }
        }
    }
}