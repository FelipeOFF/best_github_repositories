package com.example.home.activity

import com.example.common.activity.BaseActivity
import com.example.home.BR
import com.example.home.R
import com.example.home.databinding.HomeActivityBinding
import com.example.home.di.homeModule
import com.example.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class HomeActivity : BaseActivity<HomeActivityBinding, HomeViewModel>(R.layout.home_activity) {
    override val bindingVariable: Int
        get() = BR.homeViewModel

    override val viewModel: HomeViewModel by viewModel()

    override val modules: List<Module> by lazy {
        listOf(homeModule)
    }
}
