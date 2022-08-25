package com.example.home.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.common.activity.BaseActivity
import com.example.home.BR
import com.example.home.R
import com.example.home.adapter.RepositoryAdapter
import com.example.home.databinding.HomeActivityBinding
import com.example.home.di.homeModule
import com.example.home.viewmodel.HomeViewModel
import com.example.model.repository.res.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.module.Module
import timber.log.Timber

class HomeActivity : BaseActivity<HomeActivityBinding, HomeViewModel>(R.layout.home_activity) {

    private val adapter: RepositoryAdapter by lazy {
        RepositoryAdapter(::adapterListener)
    }

    override val bindingVariable: Int
        get() = BR.homeViewModel

    override val viewModel: HomeViewModel by stateViewModel(
        state = {
            intent.extras ?: Bundle()
        }
    )

    override val modules: List<Module> by lazy {
        listOf(homeModule)
    }

    override fun onResume() {
        super.onResume()
        setupView()
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.pageFlow.collectLatest { pageData ->
                adapter.submitData(pageData)
            }
        }
        lifecycleScope.launch {
            viewModel.onItemClicked.collectLatest { view ->
                when (view) {
                    R.id.errorButtonTryAgain -> {
                        adapter.refresh()
                    }
                }
                viewModel.onItemClicked.value = null
            }
        }
    }

    private fun setupView() {
        binding?.recycler?.adapter = adapter
    }

    private fun adapterListener(repository: Repository) {
        Timber.d(repository.toString()) // TODO tratar click
    }
}
