package com.example.pullrequest.viewmodel

import android.text.SpannableString
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ErrorWrapper
import com.example.domain.ResultWrapper
import com.example.domain.usecase.GetAllPullRequestFromRepositoryUseCase
import com.example.domain.util.asSuccessValueOrNull
import com.example.model.pull.request.req.GetPullRequestReq
import com.example.model.pull.request.res.PullRequest
import com.example.model.pull.request.res.StateEnum
import com.example.model.repository.res.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PullRequestViewModel constructor(
    private val getPullRequestUseCase: GetAllPullRequestFromRepositoryUseCase,
) : ViewModel() {

    private val _result: MutableStateFlow<ResultWrapper<List<PullRequest>>> =
        MutableStateFlow(ResultWrapper.DismissLoading)

    val resultSuccess: StateFlow<List<PullRequest>> = _result.mapNotNull { result ->
        result.asSuccessValueOrNull()
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val repositoryName: MutableStateFlow<String> = MutableStateFlow("")

    val showLoading: StateFlow<Boolean> = _result.map { resultWrapper ->
        loadingByResultWrapper(resultWrapper)
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)

    val showError: StateFlow<Int?> = _result.map { listOfRepositories ->
        showErrorByResultWrapper(listOfRepositories)
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    val onItemClicked: MutableStateFlow<Int?> = MutableStateFlow(null)

    val countOpenClosed: StateFlow<Pair<Int, Int>> = resultSuccess.map { list ->
        list.count { it.state == StateEnum.open } to list.count { it.state == StateEnum.closed }
    }.stateIn(viewModelScope, SharingStarted.Lazily, 0 to 0)

    val countOpenClosedString: MutableStateFlow<SpannableString?> = MutableStateFlow(null)

    fun onClickFromXML(id: Int) {
        onItemClicked.value = id
    }

    fun searchRepositoryInformation(repository: Repository) {
        viewModelScope.launch {
            val userLogin = repository.owner?.login
            repositoryName.value = repository.name.toString()

            if (userLogin != null && repositoryName.value.isNotEmpty()) {
                _result.emitAll(getPullRequestUseCase(GetPullRequestReq(userLogin, repositoryName.value)))
            }
        }
    }

    private fun showErrorByResultWrapper(result: ResultWrapper<List<PullRequest>>?): Int? =
        when (result) {
            is ResultWrapper.Success -> null
            is ResultWrapper.Error -> {
                when (result.error) {
                    is ErrorWrapper.NetworkException -> com.example.common.R.string.error_connection
                    is ErrorWrapper.Server -> com.example.common.R.string.error
                    is ErrorWrapper.UnknownException -> com.example.common.R.string.error
                }
            }

            else -> showError.value
        }

    private fun loadingByResultWrapper(result: ResultWrapper<List<PullRequest>>): Boolean =
        when (result) {
            is ResultWrapper.Loading -> true
            is ResultWrapper.DismissLoading -> false
            else -> showLoading.value
        }
}
