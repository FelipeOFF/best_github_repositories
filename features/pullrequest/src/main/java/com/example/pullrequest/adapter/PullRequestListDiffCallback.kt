package com.example.pullrequest.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.model.pull.request.res.PullRequest

class PullRequestListDiffCallback(
    private val oldList: List<PullRequest>,
    private val newList: List<PullRequest>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}
