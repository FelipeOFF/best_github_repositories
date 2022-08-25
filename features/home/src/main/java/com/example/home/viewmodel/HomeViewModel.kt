package com.example.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.cachedIn
import com.example.domain.ErrorWrapper
import com.example.domain.ResultWrapper
import com.example.domain.usecase.GetAllRepositories
import com.example.domain.util.asErrorServerOrNull
import com.example.domain.util.asErrorThrowableOrNull
import com.example.domain.util.asSuccessValueOrNull
import com.example.home.R
import com.example.model.repository.res.GitHubRepositories
import com.example.model.repository.res.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn

class HomeViewModel constructor(
    private val getAllRepositories: GetAllRepositories,
) : ViewModel() {

    private val _page: MutableStateFlow<Int> = MutableStateFlow(1)

    private val _result: MutableStateFlow<ResultWrapper<GitHubRepositories>> =
        MutableStateFlow(ResultWrapper.DismissLoading)

    private val _resultSuccess: StateFlow<GitHubRepositories?> = _result.mapNotNull { result ->
        result.asSuccessValueOrNull()
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    private val _resultError: StateFlow<ErrorWrapper?> = _result.mapNotNull { result ->
        result.asErrorServerOrNull()
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    val listOfRepositories: StateFlow<List<Repository>> = _resultSuccess.mapNotNull { repositories ->
        repositories
            ?.items
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val showLoading: StateFlow<Boolean> = _result.map { resultWrapper ->
        loadingByResultWrapper(resultWrapper)
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)

    val showError: StateFlow<Int?> = _result.map { listOfRepositories ->
        showErrorByResultWrapper(listOfRepositories)
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    val pageFlow = Pager(
        PagingConfig(pageSize = 30)
    ) {
        pageSourceRepository
    }.flow.cachedIn(viewModelScope)

    val onItemClicked: MutableStateFlow<Int?> = MutableStateFlow(null);

    fun onClickFromXML(id: Int) {
        onItemClicked.value = id
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

    private val pageSourceRepository: PagingSource<Int, Repository>
        get() = object : PagingSource<Int, Repository>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
                _page.value = params.key ?: _page.value
                _result.emitAll(getAllRepositories(params.key ?: 1))
                return if (showError.value != null) {
                    LoadResult.Error(_resultError.value?.asErrorThrowableOrNull() ?: Exception())
                } else {
                    val list: List<Repository> = listOfRepositories.value
                    LoadResult.Page(
                        data = list,
                        prevKey = null,
                        nextKey = ++_page.value
                    )
                }
            }

            override fun getRefreshKey(state: PagingState<Int, Repository>): Int? =
                state.anchorPosition?.let { anchorPosition ->
                    val anchorPage = state.closestPageToPosition(anchorPosition)
                    anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
                }
        }
}
