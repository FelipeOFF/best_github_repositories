package com.example.pullrequest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetAllPullRequestFromRepositoryUseCase
import com.example.model.repository.res.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PullRequestViewModel constructor(
    private val getPullRequestUseCase: GetAllPullRequestFromRepositoryUseCase
) : ViewModel() {

    val repositoryName: StateFlow<String> = MutableStateFlow("")

    fun searchRepositoryInformation(repository: Repository) {

    }
}