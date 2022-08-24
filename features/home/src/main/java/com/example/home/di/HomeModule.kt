package com.example.home.di

import com.example.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { param -> HomeViewModel(param.get(), get()) }
}
