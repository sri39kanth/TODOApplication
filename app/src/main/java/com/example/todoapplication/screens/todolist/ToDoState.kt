package com.example.todoapplication.screens.todolist

import com.example.todoapplication.data.ToDoContentData
import java.util.Calendar
import java.util.Date

data class ToDoState(
    val items: List<ToDoContentData> = emptyList(),
    val dateCrested: Date = Calendar.getInstance().time,
    val header: String = "",
    val content: String = "",
    val isAdding: Boolean = false,
    val sortType: SortType = SortType.DATE
)
