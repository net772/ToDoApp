package com.example.todoapp.di

import com.example.todoapp.data.repository.TestToDoRepository
import com.example.todoapp.data.repository.ToDoRepository
import com.example.todoapp.domain.todo.GetToDoListUseCase
import com.example.todoapp.domain.todo.InsertToDoListUseCase
import com.example.todoapp.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    // viewModel
    viewModel { ListViewModel(get()) }

    // usecase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }



    // repository
    single<ToDoRepository> { TestToDoRepository() }
}