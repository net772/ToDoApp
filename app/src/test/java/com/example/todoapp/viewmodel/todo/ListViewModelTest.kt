package com.example.todoapp.viewmodel.todo

import com.example.todoapp.ViewModelTest
import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.domain.todo.InsertToDoListUseCase
import com.example.todoapp.presentation.list.ListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.core.inject

@ExperimentalCoroutinesApi
internal class ListViewModelTest : ViewModelTest() {

    /**
    *필요한 Usercase들
     * 1. InsertToDoListUseCase
     * 2. GetToDoItemUserCase
    */

    private val viewModel: ListViewModel by inject()
    private val insertToDoListUseCase: InsertToDoListUseCase by inject()

    private val mockList = (0 until 10).map {
        ToDoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "description $it",
            hasCompleted = false
        )
    }

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoListUseCase(mockList)
    }

    // 테스트 : 입력된 데이터를 불러와서 검증한다.
    @Test
    fun `test viewModel fetch`(): Unit = runBlockingTest {
        val testObservable = viewModel.toDoListLiveData.test()
        viewModel.fetchData()
        testObservable.assertValueSequence(
            listOf(
                mockList
            )
        )
    }
}