package com.example.home.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.activity.BaseActivity
import com.example.common.adapter.PaginationListener
import com.example.common.helper.setItems
import com.example.home.BR
import com.example.home.R
import com.example.home.adapter.RepositoryAdapter
import com.example.home.adapter.RepositoryItemTypeAdapter
import com.example.home.databinding.HomeActivityBinding
import com.example.home.di.homeModule
import com.example.home.viewmodel.HomeViewModel
import com.example.model.repository.res.Repository
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
    }

    private fun setupView() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding?.recycler?.adapter = adapter
        binding?.recycler?.layoutManager = linearLayoutManager
        binding?.recycler?.setItems(viewModel.listOfRepositories.value)

        binding?.recycler?.addOnScrollListener(object : PaginationListener(linearLayoutManager) {
            override fun pageSize(): Int =
                viewModel.listOfRepositories.value.size

            override var isLastPage: Boolean = false
                get() = viewModel.isLastPage.value

            override var isLoading: Boolean = false
                get() = viewModel.showLoading.value

            override fun loadMoreItems() {
                viewModel.page.value = ++viewModel.page.value
            }
        })
    }

    private fun adapterListener(repository: RepositoryItemTypeAdapter) {
        Timber.d(repository.toString()) // TODO tratar click
    }
}
