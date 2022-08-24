package com.example.common.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.util.ViewTypesListener

interface ViewTypesDataBindingFactory<T> {
    fun type(model: T): Int
    fun holder(type: Int, view: ViewDataBinding, listener: ViewTypesListener<T>): AbstractViewHolder<*>
}