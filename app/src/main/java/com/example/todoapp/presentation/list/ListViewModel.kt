package com.example.todoapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.domain.todo.GetToDoListUseCase
import kotlinx.coroutines.Job
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.todo.DeleteAllToDoItemUseCase
import com.example.todoapp.domain.todo.UpdateToDoUseCase
import kotlinx.coroutines.launch

/**
 *필요한 Usercase들
 * 1. UpdateToDoListUseCase
 * 2. GetToDoListCase
 * 3. DeleteAllToDoList
 */
internal class ListViewModel (
    private val getToDoListUseCase: GetToDoListUseCase,
    private val updateToDoUseCase: UpdateToDoUseCase,
    private val deleteAllToDoItemUseCase: DeleteAllToDoItemUseCase
): ViewModel() {

    private var _toDoListLiveData = MutableLiveData<ToDoListState>(ToDoListState.UnInitialized)
    val toDoListLiveData: LiveData<ToDoListState> = _toDoListLiveData

    fun fetchData(): Job = viewModelScope.launch {
        _toDoListLiveData.postValue(ToDoListState.Loading)
        _toDoListLiveData.postValue(ToDoListState.Suceess(getToDoListUseCase()))
    }

    fun updateEntity(toDoEntity: ToDoEntity) = viewModelScope.launch {
        updateToDoUseCase(toDoEntity)
    }

    fun deleteAll() = viewModelScope.launch {
        _toDoListLiveData.postValue(ToDoListState.Loading)
        deleteAllToDoItemUseCase()
        _toDoListLiveData.postValue(ToDoListState.Suceess(getToDoListUseCase()))
    }
}