package com.txy822.apps.tflcodingchallenge_tesfahun.di

import com.google.gson.Gson
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.apiservice.ApiService
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.apiservice.ApiService.Companion.BASE_URL
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.repository.LineRepositoryImpl
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.repository.LineRepository
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.usecase.GetLineStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun providesLineStatusApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun providesLineRepository(api: ApiService): LineRepository {
        return LineRepositoryImpl(api)
    }
    @Provides
    fun provideLineStatusUseCase(repository: LineRepository): GetLineStatusUseCase{
        return GetLineStatusUseCase(repository)
    }

}