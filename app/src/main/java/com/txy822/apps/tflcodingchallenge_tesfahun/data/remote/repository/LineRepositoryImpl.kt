package com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.repository

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.apiservice.ApiService
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineResponseDtoItem
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.repository.LineRepository
import com.txy822.apps.tflcodingchallenge_tesfahun.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LineRepositoryImpl @Inject constructor(
    private val api: ApiService
) : LineRepository {
    override suspend fun getLineStatus(): Flow<Resource<List<LineResponseDtoItem>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val remoteListings = try {
                println("Error occurred 0 Size: "+api.getLineStatus().size)
                api.getLineStatus()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null // flow{null}
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null // flow{null}
            }
            remoteListings?.let { listings ->
                emit(
                    Resource.Success(
                        data = listings //from remote
                    )
                )
                emit(Resource.Loading(false))
            }
        }
    }
}