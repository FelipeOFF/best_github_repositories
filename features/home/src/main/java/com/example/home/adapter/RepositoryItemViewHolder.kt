package com.example.home.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.home.BR
import com.example.model.repository.res.Repository
import com.example.util.ViewTypesListener

class RepositoryItemViewHolder constructor(
    private val viewDataBinding: ViewDataBinding,
    private val listener: ViewTypesListener<Repository>
) : RecyclerView.ViewHolder(viewDataBinding.root) {
    fun bind(item: Repository) {
        viewDataBinding.setVariable(BR.repository, item)
        viewDataBinding.setVariable(BR.repositoryViewHolder, this)
        viewDataBinding.executePendingBindings()
    }

    fun onClickItem(item: Repository) {
        listener.invoke(item)
    }
}
