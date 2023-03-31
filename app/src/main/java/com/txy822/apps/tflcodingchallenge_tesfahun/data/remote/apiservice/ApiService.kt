package com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.apiservice

import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.dto.LineResponseDto
import retrofit2.http.GET

interface ApiService {


    @GET(END_POINT)
    suspend fun getLineStatus() : LineResponseDto

    companion object {
        const val BASE_URL = "https://api.tfl.gov.uk/"
        const val END_POINT = "Line/Mode/Tube/Status"
    }

}