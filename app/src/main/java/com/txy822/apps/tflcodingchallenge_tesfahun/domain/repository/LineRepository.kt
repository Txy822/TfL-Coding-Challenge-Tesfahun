package com.txy822.apps.tflcodingchallenge_tesfahun.domain.repository

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineResponseDtoItem
import com.txy822.apps.tflcodingchallenge_tesfahun.util.Resource
import kotlinx.coroutines.flow.Flow

interface LineRepository {
    suspend fun getLineStatus(
    ): Flow<Resource<List<LineResponseDtoItem>>>
}