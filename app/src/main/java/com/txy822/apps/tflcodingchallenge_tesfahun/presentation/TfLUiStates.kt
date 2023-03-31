package com.txy822.apps.tflcodingchallenge_tesfahun.presentation

import com.txy822.apps.tflcodingchallenge_tesfahun.domain.model.TubeLineStatusModel

data class TfLUiStates(
    val lineStatus: List<TubeLineStatusModel> = emptyList(),
    val isLoading:Boolean = false,
    val error: String = ""
)