package com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.repository

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.Crowding
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineResponseDtoItem
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineStatuse
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.ServiceType
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.repository.LineRepository
import com.txy822.apps.tflcodingchallenge_tesfahun.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.After
import org.junit.Before

class FakeLineRepository : LineRepository{
    var shouldEmitError: Boolean = false

    override suspend fun getLineStatus(): Flow<Resource<List<LineResponseDtoItem>>> {
        return flow {
            emit(Resource.Loading())
            if (!shouldEmitError) {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Success(data = getDummyList()))

            }
            else {
                emit(Resource.Loading(isLoading = false))
                emit(Resource.Error("Error message"))
            }
        }
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
}
fun getDummyList(): List<LineResponseDtoItem> {

    val list = mutableListOf<LineResponseDtoItem>()
    for (i in 1..5) {
        list.add(getDummyLineResponseItemDto())
    }
    return  list
}
fun getDummyLineResponseItemDto() = LineResponseDtoItem(
     created ="created",
    crowding= Crowding(""),
    disruptions = emptyList<Any>(),
    id ="dummy Id",
    lineStatuses =emptyList<LineStatuse>(),
    modeName ="",
    modified ="",
    name ="dummy name",
     routeSections = emptyList<Any>(),
    serviceTypes = emptyList<ServiceType>(),
    type ="dummy type"
)