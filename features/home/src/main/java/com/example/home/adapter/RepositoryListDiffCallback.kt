package com.example.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.model.repository.res.Repository

class RepositoryListDiffCallback(
    private val oldList: List<RepositoryItemTypeAdapter>,
    private val newList: List<RepositoryItemTypeAdapter>
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
