package com.example.taskfragment.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskfragment.model.Task


    @Database(entities = [Task::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun taskDao(): TaskDao
    }
