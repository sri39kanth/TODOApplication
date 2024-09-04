package com.example.todoapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoContentDao {

    @Upsert
    suspend fun insertItem(toDoContentData: ToDoContentData)

    @Delete
    suspend fun deleteItem(toDoContentData: ToDoContentData)


    @Query("SELECT * FROM ToDoContentData ORDER BY header ASC")
    fun getAllToDoItemsSortedByHeader() : Flow<List<ToDoContentData>>
}