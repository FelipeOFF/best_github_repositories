package com.example.home.di

import com.example.home.viewmodel.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    single { HomeViewModel() }
}