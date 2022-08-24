package com.example.home.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common.adapter.AbstractAdapterItems
import com.example.common.adapter.AbstractViewHolder
import com.example.common.adapter.ViewTypesDataBindingFactory
import com.example.home.R
import com.example.util.ViewTypesListener
import com.example.util.castOrNull
import com.example.util.inflateBinding

class RepositoryAdapter constructor(
    private val listener: ViewTypesListener<RepositoryItemTypeAdapter>
) : RecyclerView.Adapter<AbstractViewHolder<RepositoryItemTypeAdapter>>(), AbstractAdapterItems {

    private val repositories: MutableList<RepositoryItemTypeAdapter> = mutableListOf()

    private val viewTypesDataBindingFactoryImpl: ViewTypesDataBindingFactoryImpl by lazy {
        ViewTypesDataBindingFactoryImpl()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<RepositoryItemTypeAdapter> {
        val viewDataBinding = parent.inflateBinding(viewType)
        val holder = viewTypesDataBindingFactoryImpl.holder(type = viewType, view = viewDataBinding, listener = listener)

        @Suppress("UNCHECKED_CAST")
        return holder as AbstractViewHolder<RepositoryItemTypeAdapter>
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<RepositoryItemTypeAdapter>, position: Int) =
        holder.bind(repositories[holder.adapterPosition])

    override fun getItemCount(): Int =
        repositories.size

    override fun replaceItems(list: List<Any>) =
        setItems(list.castOrNull())

    override fun getItemViewType(position: Int): Int =
        repositories[position].type(viewTypesDataBindingFactoryImpl)

    class ViewTypesDataBindingFactoryImpl : ViewTypesDataBindingFactory<RepositoryItemTypeAdapter> {
        override fun type(model: RepositoryItemTypeAdapter): Int =
            when (model) {
                is RepositoryItemType -> R.layout.item_repository
                is LoadingItemType -> R.layout.item_loading_repository
            }

        override fun holder(
            type: Int,
            view: ViewDataBinding,
            listener: ViewTypesListener<RepositoryItemTypeAdapter>,
        ): AbstractViewHolder<*> =
            when(type) {
                R.layout.item_repository -> RepositoryItemViewHolder(view, listener)
                R.layout.item_loading_repository -> LoadingRepositoryViewHolder(view)
                else -> throw RuntimeException("Invalid view type")
            }

    }

    private fun setItems(listOfRepositories: List<RepositoryItemTypeAdapter>) {
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
