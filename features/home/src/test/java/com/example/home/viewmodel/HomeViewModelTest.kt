package com.example.home.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingSource
import com.example.domain.ResultWrapper
import com.example.domain.usecase.GetAllRepositoriesUseCase
import com.example.model.repository.res.GitHubRepositories
import com.example.model.repository.res.Repository
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = MainCoroutineRule()

    private val getAllRepositoriesUseCase: GetAllRepositoriesUseCase = mockk()

    @Test
    fun `on start home and get all repositories success`(): Unit = runTest {
        val homeViewModel: HomeViewModel = spyk(
            HomeViewModel(
                getAllRepositoriesUseCase = getAllRepositoriesUseCase
            )
        )

        every { homeViewModel.viewModelScope.coroutineContext } returns UnconfinedTestDispatcher()

        val listOfRepositories = listOf(mockk<Repository>())
        val gitRepositoriesMock: GitHubRepositories = mockk {
            every { this@mockk.items } returns listOfRepositories
        }

        every { getAllRepositoriesUseCase(1) } returns flowOf(ResultWrapper.Success(gitRepositoriesMock))

        homeViewModel.pageSourceRepository.load(PagingSource.LoadParams.Refresh(1, 30, false))


        val list = mutableListOf<List<Repository>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            homeViewModel.listOfRepositories.toList(list)
        }

        assertNotNull(list[1])
        assertEquals(list[1], listOfRepositories)

        verify(exactly = 1) { getAllRepositoriesUseCase(1) }

        collectJob.cancel()
    }
}
