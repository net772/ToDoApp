package com.example.todoapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.domain.todo.GetToDoListUseCase
import kotlinx.coroutines.Job
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 *필요한 Usercase들
 * 1. UpdateToDoListUseCase
 * 2. GetToDoListCase
 * 3. DeleteAllToDoList
 */
internal class ListViewModel (
    private val getToDoListUseCase: GetToDoListUseCase
): ViewModel() {

    private var _toDoListLiveData = MutableLiveData<List<ToDoEntity>>()
    val toDoListLiveData: LiveData<List<ToDoEntity>> = _toDoListLiveData

    fun fetchData(): Job = viewModelScope.launch {
        _toDoListLiveData.postValue(getToDoListUseCase.invoke())
    }
}