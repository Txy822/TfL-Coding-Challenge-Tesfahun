package com.txy822.apps.tflcodingchallenge_tesfahun.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.mapper.toTubeLineStatusModel
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.usecase.GetLineStatusUseCase
import com.txy822.apps.tflcodingchallenge_tesfahun.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TflViewModel @Inject constructor(
    private val useCase: GetLineStatusUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(TfLUiStates())

    val uiState: StateFlow<TfLUiStates> = _uiState.asStateFlow()

    init {
        getLineStatus()
    }

    private fun getLineStatus() {
        viewModelScope.launch(Dispatchers.IO) { //was Dispatchers.main
            useCase.getLineStatus()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                _uiState.update { it.copy(lineStatus = listings.map { it.toTubeLineStatusModel() }) }
                            }
                            _uiState.value = _uiState.value.copy()
                        }
                        is Resource.Error -> {
                            _uiState.update { it.copy(error = "Error message") }
                        }
                        is Resource.Loading -> {
                            _uiState.update { it.copy(isLoading = result.isLoading) }
                        }
                    }
                }
        }
    }
}