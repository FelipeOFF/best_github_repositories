package com.example.pullrequest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetAllPullRequestFromRepositoryUseCase

class PullRequestViewModel constructor(
    private val getPullRequestUseCase: GetAllPullRequestFromRepositoryUseCase
) : ViewModel() {
}