package com.example.todoapp.di

import com.example.todoapp.data.repository.TestToDoRepository
import com.example.todoapp.data.repository.ToDoRepository
import com.example.todoapp.domain.todo.*
import com.example.todoapp.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    // viewModel
    viewModel { ListViewModel(get(), get(), get()) }

    // usecase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { UpdateToDoUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }


    // repository
    single<ToDoRepository> { TestToDoRepository() }
}