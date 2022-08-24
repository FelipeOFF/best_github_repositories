package com.example.home.adapter

import androidx.databinding.ViewDataBinding
import com.example.common.adapter.AbstractViewHolder
import com.example.home.BR

class LoadingRepositoryViewHolder(
    private val viewDataBinding: ViewDataBinding
) : AbstractViewHolder<LoadingItemType>(viewDataBinding.root) {
    override fun bind(item: LoadingItemType) {
        viewDataBinding.setVariable(BR.loadingViewHolder, this)
        viewDataBinding.executePendingBindings()
    }
}
