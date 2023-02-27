package com.example.taskfragment

import android.app.Application
import androidx.room.Room
import com.example.taskfragment.data.local.room.AppDatabase

class App {
    class App :Application(){
        override fun onCreate() {
            super.onCreate()
            dp =  Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).allowMainThreadQueries().build()
        }
        companion object{
            lateinit var dp :AppDatabase

        }
    }
}