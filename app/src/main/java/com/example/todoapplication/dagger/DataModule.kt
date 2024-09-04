package com.example.todoapplication.dagger

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.data.ToDoContentDao
import com.example.todoapplication.data.ToDoContentDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Singleton
    @Provides
    fun provideTodoDataBase(@ApplicationContext context: Context): ToDoContentDataBase =
        Room.databaseBuilder(
         context = context,
            ToDoContentDataBase::class.java,
            "TODOContentDataBase"
        ).build()


    @Singleton
    @Provides
    fun provideTodoContentDao(@ApplicationContext context: Context): ToDoContentDao = provideTodoDataBase(context).dao
}