package com.example.todoapp.data.repository

import com.example.todoapp.data.entity.ToDoEntity

class DefaultToDoRepository: ToDoRepository {
    override suspend fun getToDoList(): List<ToDoEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getToDoItem(id: Long): ToDoEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }


}