package com.example.todoapp.viewmodel.todo

import com.example.todoapp.ViewModelTest
import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.domain.todo.GetToDoItemUseCase
import com.example.todoapp.domain.todo.InsertToDoListUseCase
import com.example.todoapp.presentation.list.ListViewModel
import com.example.todoapp.presentation.list.ToDoListState
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
    private val getToDoItemUseCase: GetToDoItemUseCase by inject()

    private val list = (0 until 10).map {
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
        insertToDoListUseCase(list)
    }

    // 테스트 : 입력된 데이터를 불러와서 검증한다.
    @Test
    fun `test viewModel fetch`(): Unit = runBlockingTest {
        val testObservable = viewModel.toDoListLiveData.test()
        viewModel.fetchData()
        testObservable.assertValueSequence( // assertValueSequence : value의 순서가 맞는지 비교합니다.
            listOf(
                ToDoListState.UnInitialized,
                ToDoListState.Loading,
                ToDoListState.Suceess(list)
            )
        )
    }

    // 테스트 : 데이터를 업데이트 했을 때 잘 반영되는가
    @Test
    fun `test Item Update`(): Unit = runBlockingTest {
        val todo = ToDoEntity(
            id = 1,
            title = "title 1",
            description = "description 1",
            hasCompleted = true
        )
        viewModel.updateEntity(todo)
        assert(getToDoItemUseCase(1)?.hasCompleted ?: false == todo.hasCompleted) // asert: 특정 조건이 맞지 않으면 예외를 발생시키는 방식
    }

    // 테스트 : 데이터를 다 날렸을 때 빈상태로 보여지는가
    @Test
    fun `test Item Delete All`(): Unit = runBlockingTest {
        val testObservable = viewModel.toDoListLiveData.test()
        viewModel.deleteAll()
        testObservable.assertValueSequence(
            listOf(
                ToDoListState.UnInitialized,
                ToDoListState.Loading,
                ToDoListState.Suceess(listOf())
            )
        )
    }
}