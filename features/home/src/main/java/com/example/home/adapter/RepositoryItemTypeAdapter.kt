package com.example.home.adapter

import com.example.common.adapter.ViewTypesDataBindingFactory
import com.example.model.repository.res.Repository

sealed class RepositoryItemTypeAdapter {
    fun type(typesFactory: ViewTypesDataBindingFactory<RepositoryItemTypeAdapter>) = typesFactory.type(model = this)
}

data class RepositoryItemType constructor(
    val repository: Repository
) : RepositoryItemTypeAdapter() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RepositoryItemType

        if (repository != other.repository) return false

        return true
    }

    override fun hashCode(): Int {
        return repository.hashCode()
    }
}

object LoadingItemType : RepositoryItemTypeAdapter()