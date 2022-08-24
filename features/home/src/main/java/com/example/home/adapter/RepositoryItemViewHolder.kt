package com.example.home.adapter

import androidx.databinding.ViewDataBinding
import com.example.common.adapter.AbstractViewHolder
import com.example.home.BR
import com.example.model.repository.res.Repository
import com.example.util.ViewTypesListener

class RepositoryItemViewHolder constructor(
    private val viewDataBinding: ViewDataBinding,
    private val listener: ViewTypesListener<RepositoryItemTypeAdapter>
) : AbstractViewHolder<RepositoryItemType>(viewDataBinding.root) {
    override fun bind(item: RepositoryItemType) {
        viewDataBinding.setVariable(BR.repository, item.repository)
        viewDataBinding.setVariable(BR.repositoryViewHolder, this)
        viewDataBinding.executePendingBindings()
    }

    fun onClickItem(item: Repository) {
        listener.invoke(RepositoryItemType(item))
    }
}
