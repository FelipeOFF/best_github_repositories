package com.example.home.viewmodel

import com.example.domain.usecase.GetAllRepositories
import io.mockk.mockk

class HomeViewModelTest {

    private val getAllRepositories: GetAllRepositories = mockk()

    private val homeViewModel: HomeViewModel = HomeViewModel(
        getAllRepositories = getAllRepositories
    )
}
