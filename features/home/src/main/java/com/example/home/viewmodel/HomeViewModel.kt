package com.example.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ErrorWrapper
import com.example.domain.ResultWrapper
import com.example.domain.usecase.GetAllRepositories
import com.example.domain.util.asSuccessValueOrNull
import com.example.home.R
import com.example.home.adapter.LoadingItemType
import com.example.home.adapter.RepositoryItemType
import com.example.home.adapter.RepositoryItemTypeAdapter
import com.example.model.repository.res.GitHubRepositories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val getAllRepositories: GetAllRepositories,
) : ViewModel() {

    val page: MutableStateFlow<Int> = MutableStateFlow(1)

    private val _result: MutableStateFlow<ResultWrapper<GitHubRepositories>> =
        MutableStateFlow(ResultWrapper.DismissLoading)

    private val _resultSuccess: StateFlow<GitHubRepositories?> = _result.mapNotNull { result ->
        result.asSuccessValueOrNull()
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    val listOfRepositories: StateFlow<List<RepositoryItemTypeAdapter>> = _resultSuccess.mapNotNull { repositories ->
        incrementList(repositories)
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val showLoading: StateFlow<Boolean> = _result.map { resultWrapper ->
        loadingByResultWrapper(resultWrapper)
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)

    val showError: StateFlow<Int?> = _result.map { listOfRepositories ->
        showErrorByResultWrapper(listOfRepositories)
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    val isLastPage: StateFlow<Boolean> = _resultSuccess.map { repositories ->
        repositories?.incompleteResults == true
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)

    init {
        viewModelScope.launch {
            page.collect {
                startOrUpdateValues()
            }
        }
    }

    fun startOrUpdateValues() {
        viewModelScope.launch {
            _result.emitAll(getAllRepositories(page.value))
        }
    }

    private fun showErrorByResultWrapper(result: ResultWrapper<GitHubRepositories>?): Int? =
        when (result) {
            is ResultWrapper.Success -> null
            is ResultWrapper.Error -> {
                when (result.error) {
                    is ErrorWrapper.NetworkException -> R.string.error_connection
                    is ErrorWrapper.Server -> R.string.error
                    is ErrorWrapper.UnknownException -> R.string.error
                }
            }

            else -> showError.value
        }

    private fun loadingByResultWrapper(result: ResultWrapper<GitHubRepositories>): Boolean =
        when (result) {
            is ResultWrapper.Loading -> true
            is ResultWrapper.DismissLoading -> false
            else -> showLoading.value
        }

    private fun incrementList(repositories: GitHubRepositories?): MutableList<RepositoryItemTypeAdapter>? =
        listOfRepositories.value.toMutableList().apply {
            remove(LoadingItemType)
            addAll(
                repositories
                    ?.items
                    ?.map { RepositoryItemType(it) }
                    ?.toMutableList<RepositoryItemTypeAdapter>()
                    ?.apply {
                        add(LoadingItemType)
                    } ?: emptyList()
            )
        }
}
