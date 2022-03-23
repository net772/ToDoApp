package com.example.todoapp.viewmodel.todo

import com.example.todoapp.ViewModelTest
import com.example.todoapp.presentation.list.ListViewModel
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.koin.core.inject
// 16분부터
internal class ListViewModelTest : ViewModelTest() {

    /**
    *필요한 Usercase들
     * 1. InsertToDoListUseCase
     * 2. GetToDoItemUserCase
    */

    private val viewModel: ListViewModel by inject()

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
    }
}