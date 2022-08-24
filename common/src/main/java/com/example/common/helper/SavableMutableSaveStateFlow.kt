package com.example.common.helper

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SavableMutableSaveStateFlow<T>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    defaultValue: T,
) {
    private val _state: MutableStateFlow<T> =
        MutableStateFlow(
            savedStateHandle.get<T>(key) ?: defaultValue
        )

    var value: T
        get() = _state.value
        set(value) {
            _state.value = value
            savedStateHandle[key] = value
        }

    fun asStateFlow(): StateFlow<T> = _state
}
