package com.example.pullrequest.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common.adapter.AbstractAdapterItems
import com.example.model.pull.request.res.PullRequest
import com.example.pullrequest.R
import com.example.util.ViewTypesListener
import com.example.util.castOrNull
import com.example.util.inflateBinding

class PullRequestAdapter constructor(
    private val listener: ViewTypesListener<PullRequest>,
) : RecyclerView.Adapter<PullRequestItemViewHolder>(), AbstractAdapterItems {

    private val pullRequest: MutableList<PullRequest> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestItemViewHolder {
        val viewDataBinding = parent.inflateBinding(R.layout.item_pullrequest)
        return PullRequestItemViewHolder(viewDataBinding, listener)
    }

    override fun getItemCount(): Int =
        pullRequest.size

    override fun onBindViewHolder(holder: PullRequestItemViewHolder, position: Int) =
        holder.bind(pullRequest[position])

    override fun replaceItems(list: List<Any>) =
        setItems(list.castOrNull())

    private fun setItems(listOfUsers: List<PullRequest>) {
        val result = DiffUtil.calculateDiff(
            PullRequestListDiffCallback(
                listOfUsers,
                pullRequest
            )
        )
        result.dispatchUpdatesTo(this)
        pullRequest.clear()
        pullRequest.addAll(listOfUsers)
    }
}
