package com.example.pullrequest.activity

import android.os.Bundle
import com.example.common.activity.BaseActivity
import com.example.pullrequest.BR
import com.example.pullrequest.R
import com.example.pullrequest.databinding.PullRequestActivityBinding
import com.example.pullrequest.di.pullRequestModule
import com.example.pullrequest.viewmodel.PullRequestViewModel
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.module.Module

class PullRequestActivity : BaseActivity<PullRequestActivityBinding, PullRequestViewModel>(R.layout.pull_request_activity) {

    override val bindingVariable: Int? = BR.pullRequestViewModel

    override val viewModel: PullRequestViewModel by stateViewModel(
        state = {
            intent.extras ?: Bundle()
        }
    )

    override val modules: List<Module> =
        listOf(pullRequestModule)
}