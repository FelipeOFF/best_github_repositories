package com.example.common.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.common.navigation.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel>(
    @LayoutRes val layout: Int
) : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    abstract val bindingVariable: Int?

    abstract val viewModel: VM?

    val binding: VB? by lazy {
        setupBinding()
    }

    val navigation: Navigation by inject()

    override fun onResume() {
        super.onResume()
        binding // only for load layout
    }

    private fun setupBinding(): VB? {
        val binding = DataBindingUtil.setContentView<VB>(this, layout)
        bindingVariable?.let { bindingVariable ->
            binding?.setVariable(bindingVariable, viewModel)
        }
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        return binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    open val modules: List<Module>? = null

    private val loadFeature by lazy {
        modules?.let { modulesList ->
            loadKoinModules(modulesList)
            modulesList
        }
    }

    private fun injectFeature() = loadFeature

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
