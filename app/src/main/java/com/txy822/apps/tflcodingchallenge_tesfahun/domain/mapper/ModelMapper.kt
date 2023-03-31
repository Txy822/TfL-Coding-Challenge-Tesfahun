package com.txy822.apps.tflcodingchallenge_tesfahun.domain.mapper

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineResponseDtoItem
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineStatuse
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.model.LineStatuseModel
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.model.TubeLineStatusModel

fun LineResponseDtoItem.toTubeLineStatusModel(): TubeLineStatusModel = TubeLineStatusModel(
    id=id,name= name, lineStatuses = lineStatuses.map { it.toLineStatusModel() }
)

fun LineStatuse.toLineStatusModel(): LineStatuseModel = LineStatuseModel(
    id =id,reason= reason,statusSeverityDescription=statusSeverityDescription
)