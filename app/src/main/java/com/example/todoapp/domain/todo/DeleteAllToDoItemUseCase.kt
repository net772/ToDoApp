package com.example.todoapp.domain.todo

import com.example.todoapp.data.repository.ToDoRepository
import com.example.todoapp.domain.UseCase

class DeleteAllToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {

    suspend operator fun invoke() {
        return toDoRepository.deleteAll()
    }

}