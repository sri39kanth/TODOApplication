package com.example.todoapplication.screens.todolist

import com.example.todoapplication.data.ToDoContentData
import java.util.Date

sealed interface ToDoClickEvent {
    data object SaveToDoItem : ToDoClickEvent
    data class SaveDate(val date: Date) : ToDoClickEvent
    data class SaveHeader(val header: String) : ToDoClickEvent
    data class SaveContent(val content: String) : ToDoClickEvent
    data class DeleteContact(val toDoContentData: ToDoContentData) : ToDoClickEvent
    data object ShowAddToDoItem : ToDoClickEvent
    data object HideAddToDoItem : ToDoClickEvent
    data class SortType(val sortType: com.example.todoapplication.screens.todolist.SortType) : ToDoClickEvent
}