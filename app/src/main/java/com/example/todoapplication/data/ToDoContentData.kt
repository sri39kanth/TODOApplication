package com.example.todoapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.Date

@Entity
data class ToDoContentData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val header: String,
    val content: String
)
