package com.example.taskfragment.ui.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: String? = null,
    val title: String? = null,
    val description:String? =null


):java.io.Serializable
