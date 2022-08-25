package com.example.home.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.home.R
import com.example.model.repository.res.Repository
import com.example.util.ViewTypesListener
import com.example.util.inflateBinding

class RepositoryAdapter constructor(
    private val listener: ViewTypesListener<Repository>
) : PagingDataAdapter<Repository, RepositoryItemViewHolder>(RepositoryListDiffItemCallback) {

    override fun onBindViewHolder(holder: RepositoryItemViewHolder, position: Int) {
        getItem(position)?.let {repositoryTipe ->
            holder.bind(repositoryTipe)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItemViewHolder {
        val viewDataBinding = parent.inflateBinding(R.layout.item_repository)
        return RepositoryItemViewHolder(viewDataBinding, listener)
    }
}
