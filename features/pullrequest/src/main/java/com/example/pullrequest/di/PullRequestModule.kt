package com.example.pullrequest.di

import com.example.pullrequest.viewmodel.PullRequestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pullRequestModule = module {
    viewModel { PullRequestViewModel(get()) }
}