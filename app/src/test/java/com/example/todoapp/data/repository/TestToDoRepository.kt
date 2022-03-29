package com.example.todoapp.data.repository

import com.example.todoapp.data.entity.ToDoEntity

class TestToDoRepository: ToDoRepository {

    private val toDoList: MutableList<ToDoEntity> = mutableListOf()

    override suspend fun getToDoList(): List<ToDoEntity> {
        return toDoList
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        this.toDoList.addAll(toDoList)
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity): Boolean {
        val foundToDoEntity = toDoList.find { it.id == toDoEntity.id }
        return if (foundToDoEntity == null) {
            false
        } else {
            this.toDoList[toDoList.indexOf(foundToDoEntity)] = toDoEntity
            true
        }

    }

    override suspend fun getToDoItem(id: Long): ToDoEntity? {
        return toDoList.find { it.id == id }
    }

    override suspend fun deleteAll() {
        this.toDoList.clear()
    }


}