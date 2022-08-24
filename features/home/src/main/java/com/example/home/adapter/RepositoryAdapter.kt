package com.example.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common.adapter.AbstractAdapterItems
import com.example.home.R
import com.example.model.repository.res.Repository
import com.example.util.ViewTypesListener
import com.example.util.castOrNull
import com.example.util.inflateBinding

class RepositoryAdapter constructor(
    private val listener: ViewTypesListener<Repository>
) : RecyclerView.Adapter<RepositoryItemViewHolder>(), AbstractAdapterItems {

    private val repositories: MutableList<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryItemViewHolder {
        val viewDataBinding = parent.inflateBinding(R.layout.item_repository)
        return RepositoryItemViewHolder(viewDataBinding, listener)
    }

    override fun onBindViewHolder(holder: RepositoryItemViewHolder, position: Int) {
        holder.bind(repositories[position])
    }

    override fun getItemCount(): Int =
        repositories.size

    override fun replaceItems(list: List<Any>) =
        setItems(list.castOrNull())

    private fun setItems(listOfRepositories: List<Repository>) {
        val result = DiffUtil.calculateDiff(
            RepositoryListDiffCallback(
                listOfRepositories,
                repositories
            )
        )
        result.dispatchUpdatesTo(this)
        repositories.clear()
        repositories.addAll(listOfRepositories)
    }
}
