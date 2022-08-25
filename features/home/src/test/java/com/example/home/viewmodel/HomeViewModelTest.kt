package com.example.home.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingSource
import com.example.domain.ResultWrapper
import com.example.domain.usecase.GetAllRepositories
import com.example.model.repository.res.GitHubRepositories
import com.example.model.repository.res.Repository
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
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

    private val getAllRepositories: GetAllRepositories = mockk()

    @Test
    fun `on start home and get all repositories success`(): Unit = runTest {
        val homeViewModel: HomeViewModel = spyk(
            HomeViewModel(
                getAllRepositories = getAllRepositories
            )
        )

        every { homeViewModel.viewModelScope.coroutineContext } returns UnconfinedTestDispatcher()

        val listOfRepositories = listOf(mockk<Repository>())
        val gitRepositoriesMock: GitHubRepositories = mockk {
            every { this@mockk.items } returns listOfRepositories
        }

        every { getAllRepositories(1) } returns flowOf(ResultWrapper.Success(gitRepositoriesMock))

        homeViewModel.pageSourceRepository.load(PagingSource.LoadParams.Refresh(1, 30, false))


        val list = mutableListOf<List<Repository>>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            homeViewModel.listOfRepositories.toList(list)
        }

        assertNotNull(list[1])
        assertEquals(list[1], listOfRepositories)

        verify(exactly = 1) { getAllRepositories(1) }

        collectJob.cancel()
    }
}
