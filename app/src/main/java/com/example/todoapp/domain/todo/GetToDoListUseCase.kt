package com.example.todoapp.domain.todo

import com.example.todoapp.data.repository.ToDoRepository
import com.example.todoapp.domain.UseCase

class GetToDoListUseCase(
    private val ToDoRepository: ToDoRepository
) : UseCase {
}