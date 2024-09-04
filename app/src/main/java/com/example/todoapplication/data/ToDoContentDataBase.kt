package com.example.todoapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ToDoContentData::class],
    version = 1
)
abstract class ToDoContentDataBase : RoomDatabase(){

    abstract val dao : ToDoContentDao
}