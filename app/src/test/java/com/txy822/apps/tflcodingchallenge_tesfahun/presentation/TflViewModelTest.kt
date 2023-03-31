package com.txy822.apps.tflcodingchallenge_tesfahun.presentation

import android.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.repository.FakeLineRepository
import com.txy822.apps.tflcodingchallenge_tesfahun.data.remote.repository.getDummyList
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.mapper.toTubeLineStatusModel
import com.txy822.apps.tflcodingchallenge_tesfahun.domain.usecase.GetLineStatusUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TflViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutionRule: TestRule = InstantTaskExecutorRule()

    var tubeLineRepository: FakeLineRepository = FakeLineRepository()
    var getTubeLineStatusUseCase: GetLineStatusUseCase = GetLineStatusUseCase(tubeLineRepository)
    var tubeLineViewModel: TflViewModel = TflViewModel(getTubeLineStatusUseCase)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {

        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `success data response from api`() = runTest {
        tubeLineViewModel.uiState.test {
            assertEquals(awaitItem(), TfLUiStates(isLoading = false)) //initialise state
            assertEquals(
                getDummyList().map { it.toTubeLineStatusModel() },
                awaitItem().lineStatus
            ) //emit  data
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `failure data response from api`() = runTest {
        tubeLineRepository.shouldEmitError = true
        tubeLineViewModel.uiState.test {

           // assertEquals(awaitItem(), TfLUiStates(isLoading = false)) //initialise state
            // testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(awaitItem(), TfLUiStates(error = "Error message")) //initialise state
             //assertEquals("Error message", awaitItem().error) //emit  data
        }
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
          Dispatchers.resetMain()
    }
}
