package com.example.pullrequest.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.common.activity.BaseActivity
import com.example.model.repository.res.Repository
import com.example.pullrequest.BR
import com.example.pullrequest.R
import com.example.pullrequest.databinding.PullRequestActivityBinding
import com.example.pullrequest.di.pullRequestModule
import com.example.pullrequest.viewmodel.PullRequestViewModel
import com.example.util.Const
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.module.Module

class PullRequestActivity : BaseActivity<PullRequestActivityBinding, PullRequestViewModel>(R.layout.pull_request_activity) {

    private val repository: Repository by lazy {
        checkNotNull(intent.extras?.getParcelable(Const.ActivityParameters.REPOSITORY_PARAMETER))
    }

    override val bindingVariable: Int? = BR.pullRequestViewModel

    override val viewModel: PullRequestViewModel by stateViewModel(
        state = {
            intent.extras ?: Bundle()
        }
    )

    override fun onResume() {
        super.onResume()
        viewModel.searchRepositoryInformation(repository)

        lifecycleScope.launch {
            viewModel.onItemClicked.collectLatest {view ->
                when(view) {
                    R.id.toolbar -> finish()
                }
            }
        }
    }

    override val modules: List<Module> =
        listOf(pullRequestModule)
}