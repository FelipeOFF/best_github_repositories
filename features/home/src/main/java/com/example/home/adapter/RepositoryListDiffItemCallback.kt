package com.example.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.model.repository.res.Repository

object RepositoryListDiffItemCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean =
        oldItem == newItem
}
