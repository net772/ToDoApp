package com.example.todoapp.data.repository

import com.example.todoapp.data.entity.ToDoEntity

interface ToDoRepository {

    suspend fun getToDoList(): List<ToDoEntity>
    suspend fun insertToDoList(toDoList: List<ToDoEntity>)
    suspend fun updateToDoItem(toDoEntity: ToDoEntity): Boolean
    suspend fun getToDoItem(id: Long): ToDoEntity?
    suspend fun deleteAll()
}