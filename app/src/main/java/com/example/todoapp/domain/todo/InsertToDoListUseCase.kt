package com.example.todoapp.domain.todo

import com.example.todoapp.data.repository.ToDoRepository
import com.example.todoapp.domain.UseCase

class InsertToDoListUseCase(
    private val toDoRepository: ToDoRepository
) : UseCase {
}