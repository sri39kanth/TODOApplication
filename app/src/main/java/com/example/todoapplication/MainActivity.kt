package com.example.todoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapplication.screens.compose.ToDoAddItemComposable
import com.example.todoapplication.screens.compose.ToDoItemsListComposable
import com.example.todoapplication.screens.todolist.ToDoState
import com.example.todoapplication.ui.theme.TODOApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOApplicationTheme {
                val viewModel: MainViewModelImpl = hiltViewModel()

                val toDoState =  viewModel.toDoState.collectAsState().value

                if(toDoState.isAdding) {
                    ToDoAddItemComposable(toDoState = toDoState, onEvent = viewModel::onEvent)
                } else {
                    ToDoItemsListComposable(toDoState = toDoState, onEvent = viewModel::onEvent)
                }

            }
        }
    }
}
