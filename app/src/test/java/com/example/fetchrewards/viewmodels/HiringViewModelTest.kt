package com.example.fetchrewards.viewmodels

import com.example.fetchrewards.TestDispatcherRule
import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.ServiceResult
import com.example.fetchrewards.repository.HiringRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HiringViewModelTest {

    private val hiringRepository = mockk<HiringRepository>()

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Before
    fun setup() {

    }

    @After
    fun tearDown() {
        clearAllMocks()
    }


    @Test
    fun `when viewmodel initialized fetchHiringList called and return success`() = runTest {
        val mockResponse = listOf(
            HiringResponse(id = 1, listId = 123, name = "abc"),
            HiringResponse(id = 2, listId = 13, name = "id2"),
            HiringResponse(id = 3, listId = 1, name = "bac"),
            HiringResponse(id = 4, listId = 1, name = "cac")
        )
        coEvery {
            hiringRepository.getHiringList()
        } returns ServiceResult.Success(mockResponse)

        val viewModel = HiringViewModel(hiringRepository)
        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertFalse(state.isLoading)
        assert(state.errorMessage.isNullOrEmpty())
        assertEquals(state.hiringList[3].name, "abc")
        assertEquals(state.hiringList[1].name, "cac")

    }

    @Test
    fun `when viewmodel initialized fetchHiringList called and return error`() = runTest {

        coEvery {
            hiringRepository.getHiringList()
        } returns ServiceResult.Error("Error")

        val viewModel = HiringViewModel(hiringRepository)
        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertFalse(state.isLoading)
        assert(state.errorMessage.equals("Error"))
        assert(state.hiringList.isEmpty())
    }

}