package com.example.todoapplication.screens.compose

import android.media.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapplication.screens.todolist.ToDoClickEvent
import com.example.todoapplication.screens.todolist.ToDoState


@Composable
fun ToDoItemsListComposable(
     toDoState: ToDoState,
     onEvent: (ToDoClickEvent) -> Unit
) {
      Scaffold(
           floatingActionButton = {
                FloatingActionButton(onClick = { onEvent(ToDoClickEvent.ShowAddToDoItem) }) {
                     Icon(imageVector = Icons.Default.Add, contentDescription = "ADD")
                }
           },
           modifier = Modifier.fillMaxSize()
      ) { padding ->


      }
}