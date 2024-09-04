package com.example.todoapplication

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.ToDoContentDao
import com.example.todoapplication.screens.todolist.ToDoClickEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


abstract class MainViewModel : ViewModel(){

    abstract fun onEvent(toDoClickEvent: ToDoClickEvent)
}