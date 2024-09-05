package com.example.todoapplication.screens.compose

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.BlendModeColorFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapplication.R
import com.example.todoapplication.screens.todolist.ToDoClickEvent
import com.example.todoapplication.screens.todolist.ToDoState
import com.example.todoapplication.ui.theme.TODOApplicationTheme


@Composable
fun ToDoItemsListComposable(
     toDoState: ToDoState,
     onEvent: (ToDoClickEvent) -> Unit
) {
    Surface (modifier = Modifier.padding(20.dp)){
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { onEvent(ToDoClickEvent.ShowAddToDoItem) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "ADD")
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { padding ->
            if (toDoState.isAdding) {
                ToDoAddItemComposable(toDoState = toDoState, onEvent = onEvent)
            }

            LazyColumn {
                item {
                    Text(text = stringResource(R.string.all_the_todo_items_are_listed_here),
                        fontSize = 20.sp)
                }
                items(toDoState.items) { it ->
                    Column(modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .background(Color.Gray)
                        ) {
                        Text(text = it.header)
                        Text(text = it.content)
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListPreview(){
    TODOApplicationTheme {
        ToDoItemsListComposable(toDoState = ToDoState()) {
            
        }
    }
}