package com.example.common.helper

import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@BindingAdapter("dividerDecoration")
fun RecyclerView.setDividerDecoration(orientation: Int) {
    val linearLayoutManager = layoutManager as? LinearLayoutManager
    addItemDecoration(DividerItemDecoration(context, linearLayoutManager?.orientation ?: orientation))
}
