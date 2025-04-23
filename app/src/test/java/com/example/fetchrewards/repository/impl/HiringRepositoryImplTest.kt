package com.example.fetchrewards.repository.impl

import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.HiringService
import com.example.fetchrewards.api.ServiceResult
import com.example.fetchrewards.repository.HiringRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HiringRepositoryImplTest {

    private val hiringService = mockk<HiringService>()

    private lateinit var hiringRepository: HiringRepository

    @Before
    fun setup() {
        hiringRepository = HiringRepositoryImpl(hiringService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `when get hiring list is called return success`() {

        val mockResponse = listOf(
            HiringResponse(1, 123, "id1"),
            HiringResponse(2, 13, "id2"),
            HiringResponse(3, 123, "id3")
        )
        runTest {
            coEvery {
                hiringService.getHiringList()
            } returns mockResponse

            val result = hiringRepository.getHiringList()

            assert(result is ServiceResult.Success)
            assertEquals(mockResponse, (result as ServiceResult.Success).data)
        }
    }


    @Test
    fun `when get hiring list is called return error`() {
        runTest {
            coEvery {
                hiringService.getHiringList()
            } throws Exception("error")

            val result = hiringRepository.getHiringList()

            assert(result is ServiceResult.Error)
            assertEquals("error", (result as ServiceResult.Error).message)
        }
    }
}

