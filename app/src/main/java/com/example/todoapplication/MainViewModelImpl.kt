package com.example.todoapplication

import androidx.lifecycle.viewModelScope
import com.example.todoapplication.data.ToDoContentDao
import com.example.todoapplication.data.ToDoContentData
import com.example.todoapplication.screens.todolist.SortType
import com.example.todoapplication.screens.todolist.ToDoClickEvent
import com.example.todoapplication.screens.todolist.ToDoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject
constructor(
    private val dao: ToDoContentDao,
    private val dispatcherProvider: DispatcherProvider): MainViewModel() {

    private val _sortType = MutableStateFlow(SortType.HEADER)
    private val _todoSate = MutableStateFlow(ToDoState())

    @OptIn(ExperimentalCoroutinesApi::class)
    val toDoItems  = _sortType
        .flatMapLatest { sortType ->

            when(sortType) {
                SortType.DATE -> dao.getAllToDoItemsSortedByHeader()
                SortType.HEADER -> dao.getAllToDoItemsSortedByHeader()
            }

        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val toDoState = combine(toDoItems, _sortType, _todoSate) { toDoItems, sortType, todoState ->

        todoState.copy(
            items = toDoItems,
            sortType = sortType
        )

    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(500L), ToDoState())

    override fun onEvent(toDoClickEvent: ToDoClickEvent) {

        when(toDoClickEvent) {
            is ToDoClickEvent.DeleteContact -> {
                viewModelScope.launch(dispatcherProvider.main()) {
                 dao.deleteItem(toDoClickEvent.toDoContentData)
                }
            }
            ToDoClickEvent.HideAddToDoItem -> {
                _todoSate.update {
                    it.copy(isAdding = false)
                }
            }
            is ToDoClickEvent.SaveContent -> {
                _todoSate.update {
                    it.copy(content = toDoClickEvent.content)
                }
            }
            is ToDoClickEvent.SaveDate -> {


            }
            is ToDoClickEvent.SaveHeader -> {
                _todoSate.update {
                    it.copy(header = toDoClickEvent.header)
                }
            }
            ToDoClickEvent.SaveToDoItem -> {
                val header = _todoSate.value.header
                val content = _todoSate.value.content
                viewModelScope.launch(dispatcherProvider.main()) {
                    dao.insertItem(ToDoContentData(header = header, content = content))
                }
                _todoSate.update {
                    it.copy(isAdding = false,  header = "", content = "")
                }

            }
            ToDoClickEvent.ShowAddToDoItem -> {
                _todoSate.update {
                    it.copy(isAdding = true)
                }
            }
            is ToDoClickEvent.SortType -> {
                _sortType.value = toDoClickEvent.sortType
            }
        }
    }
}