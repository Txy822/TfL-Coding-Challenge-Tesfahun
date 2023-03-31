package com.txy822.apps.tflcodingchallenge_tesfahun.domain.model


data class TubeLineStatusModel(
    val id:String,
    val name:String,
    val lineStatuses: List<LineStatuseModel>,
    )