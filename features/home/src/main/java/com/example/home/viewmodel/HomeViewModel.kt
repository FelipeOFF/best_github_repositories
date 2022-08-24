package com.example.home.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ErrorWrapper
import com.example.domain.ResultWrapper
import com.example.domain.usecase.GetAllRepositories
import com.example.domain.util.asSuccessValueOrNull
import com.example.home.R
import com.example.model.repository.res.GitHubRepositories
import com.example.model.repository.res.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getAllRepositories: GetAllRepositories,
) : ViewModel() {

    private val _page: MutableStateFlow<Int> = MutableStateFlow(1)

    private val _result: MutableStateFlow<ResultWrapper<GitHubRepositories>> =
        MutableStateFlow(ResultWrapper.DismissLoading)

    val listOfRepositories: StateFlow<List<Repository>> = _result.map { result ->
        result.asSuccessValueOrNull()?.items ?: emptyList()
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val showLoading: StateFlow<Boolean> = _result.map { listOfRepositories ->
        loadingByResultWrapper(listOfRepositories)
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)

    val showError: StateFlow<Int?> = _result.map { listOfRepositories ->
        showErrorByResultWrapper(listOfRepositories)
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    init {
        startOrUpdateValues()
    }

    fun startOrUpdateValues() {
        viewModelScope.launch {
            val getFromState = savedStateHandle.get<GitHubRepositories>(SAVE_RESULT_STATE_KEY)
            val getPageFromState = savedStateHandle.get<Int>(SAVE_PAGE_STATE_KEY)
            if (getFromState != null && getPageFromState != null) {
                _page.value = getPageFromState
                _result.value = ResultWrapper.Success(getFromState)
            } else {
                val getResultFromDomain = getAllRepositories(_page.value).map { result ->
                    result.asSuccessValueOrNull()?.let { gitHubRepositories ->
                        savedStateHandle[SAVE_RESULT_STATE_KEY] = gitHubRepositories
                        savedStateHandle[SAVE_PAGE_STATE_KEY] = _page.value
                    }
                    result
                }
                _result.emitAll(getResultFromDomain)
            }
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

            else -> null
        }

    private fun loadingByResultWrapper(result: ResultWrapper<GitHubRepositories>): Boolean =
        when (result) {
            is ResultWrapper.Loading -> true
            is ResultWrapper.DismissLoading -> false
            is ResultWrapper.Error -> false
            is ResultWrapper.Success -> false
        }

    companion object {
        private const val SAVE_RESULT_STATE_KEY = "home_view_result_state"
        private const val SAVE_PAGE_STATE_KEY = "home_view_page_state"
    }
}
