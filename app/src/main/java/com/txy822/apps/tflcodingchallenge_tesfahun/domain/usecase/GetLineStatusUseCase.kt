package com.txy822.apps.tflcodingchallenge_tesfahun.domain.usecase

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineResponseDtoItem
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.repository.LineRepository
import com.txy822.apps.tflcodingchallenge_tesfahun.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLineStatusUseCase @Inject constructor(
    private val repository:LineRepository
)
{
    suspend fun getLineStatus(): Flow<Resource<List<LineResponseDtoItem>>>{
        return repository.getLineStatus()
    }
}