package com.example.pullrequest.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.model.pull.request.res.PullRequest
import com.example.pullrequest.BR
import com.example.util.ViewTypesListener

class PullRequestItemViewHolder(
    private val viewDataBinding: ViewDataBinding,
    private val listener: ViewTypesListener<PullRequest>,
) : RecyclerView.ViewHolder(viewDataBinding.root) {
    fun bind(item: PullRequest) {
        viewDataBinding.setVariable(BR.pullRequest, item)
        viewDataBinding.setVariable(BR.pullRequestViewHolder, this)
        viewDataBinding.executePendingBindings()
    }

    fun onClickItem(item: PullRequest) {
        listener.invoke(item)
    }
}
