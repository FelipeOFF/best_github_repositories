package com.example.pullrequest.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.common.activity.BaseActivity
import com.example.common.helper.SpannableStringCreator
import com.example.common.helper.resSpans
import com.example.model.pull.request.res.PullRequest
import com.example.model.repository.res.Repository
import com.example.pullrequest.BR
import com.example.pullrequest.R
import com.example.pullrequest.adapter.PullRequestAdapter
import com.example.pullrequest.databinding.PullRequestActivityBinding
import com.example.pullrequest.di.pullRequestModule
import com.example.pullrequest.viewmodel.PullRequestViewModel
import com.example.util.Const
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.module.Module


class PullRequestActivity :
    BaseActivity<PullRequestActivityBinding, PullRequestViewModel>(R.layout.pull_request_activity) {

    private val adapter: PullRequestAdapter by lazy {
        PullRequestAdapter(::onClickItem)
    }

    private val repository: Repository by lazy {
        checkNotNull(intent.extras?.getParcelable(Const.ActivityParameters.REPOSITORY_PARAMETER))
    }

    override val bindingVariable: Int = BR.pullRequestViewModel

    override val viewModel: PullRequestViewModel by stateViewModel(
        state = {
            intent.extras ?: Bundle()
        }
    )

    override fun onResume() {
        super.onResume()
        viewModel.searchRepositoryInformation(repository)
        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.onItemClicked.collectLatest { view ->
                when (view) {
                    R.id.toolbar -> finish()
                    R.id.errorButtonTryAgain ->
                        viewModel.searchRepositoryInformation(repository)
                }
                viewModel.onItemClicked.value = null
            }
        }

        lifecycleScope.launch {
            viewModel.countOpenClosed.collectLatest { (open, closed) ->
                viewModel.countOpenClosedString.value =
                    SpannableStringCreator()
                        .append(getString(R.string.opened, open), resSpans {
                            color(com.example.common.R.color.colorDetail)
                        })
                        .appendSpace(getString(R.string.bar))
                        .appendSpace(getString(R.string.closed, closed))
                        .toSpannableString()
            }
        }
    }

    private fun setupViews() {
        binding?.recycler?.adapter = adapter
    }

    override val modules: List<Module> =
        listOf(pullRequestModule)

    private fun onClickItem(pullRequest: PullRequest) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pullRequest.htmlUrl))
        startActivity(browserIntent)
    }
}
