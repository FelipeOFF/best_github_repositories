package com.example.common.helper

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("dividerDecoration")
fun RecyclerView.setDividerDecoration(orientation: Int) {
    val linearLayoutManager = layoutManager as? LinearLayoutManager
    addItemDecoration(DividerItemDecoration(context, linearLayoutManager?.orientation ?: orientation))
}
