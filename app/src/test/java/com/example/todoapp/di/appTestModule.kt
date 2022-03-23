package com.example.todoapp.di

import com.example.todoapp.data.repository.TestToDoRepository
import com.example.todoapp.data.repository.ToDoRepository
import com.example.todoapp.domain.todo.GetToDoListUseCase
import com.example.todoapp.domain.todo.InsertToDoListUseCase
import org.koin.dsl.module

internal val appTestModule = module {

    // usecase
    factory { GetToDoListUseCase() }
    factory { InsertToDoListUseCase() }



    // repository
    single<ToDoRepository> { TestToDoRepository() }
}