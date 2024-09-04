package com.example.todoapplication.dagger

import com.example.todoapplication.DispatcherProvider
import com.example.todoapplication.DispatcherProviderImpl
import com.example.todoapplication.MainViewModel
import com.example.todoapplication.MainViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun provideMainViewModel(mainViewModelImpl: MainViewModelImpl): MainViewModel

    @Binds
    @Singleton
    abstract fun getDispatcherProvider(dispatcherProviderImpl: DispatcherProviderImpl) : DispatcherProvider
}