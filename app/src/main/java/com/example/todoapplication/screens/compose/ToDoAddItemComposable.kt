package com.example.todoapplication.screens.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapplication.screens.todolist.ToDoClickEvent
import com.example.todoapplication.screens.todolist.ToDoState
import com.example.todoapplication.ui.theme.TODOApplicationTheme

@Composable
fun ToDoAddItemComposable(
    toDoState: ToDoState,
    onEvent: (ToDoClickEvent) -> Unit
) {
    Surface {
        Column {
           SaveDeleteComposable(onEvent)
            TextField(
                value = toDoState.header,
                onValueChange = {
                    onEvent(ToDoClickEvent.SaveHeader(it))
                },
                placeholder = {
                    Text(text = "Add the title for todo items")
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            TextField(
                value = toDoState.content, onValueChange = {
                    onEvent(ToDoClickEvent.SaveContent(it))
                },
                placeholder = {
                    Text(text = "Add the content of the items")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }

    }
}


@Composable
fun SaveDeleteComposable(onEvent: (ToDoClickEvent) -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
    ) {
        Box(modifier = Modifier.weight(1f)) {
            IconButton(onClick = { onEvent(ToDoClickEvent.HideAddToDoItem) }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
            }
        }
        Box {
            IconButton(onClick = { onEvent(ToDoClickEvent.SaveToDoItem) }) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "Save")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun ToDoItemPreview(){
    TODOApplicationTheme {
        ToDoAddItemComposable(toDoState = ToDoState()) {}
    }
}