package com.example.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.model.repository.res.Repository

class RepositoryListDiffCallback(
    private val oldList: List<Repository>,
    private val newList: List<Repository>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
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
