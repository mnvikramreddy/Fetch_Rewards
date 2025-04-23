package com.example.fetchrewards.repository.impl

import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.HiringService
import com.example.fetchrewards.api.ServiceResult
import com.example.fetchrewards.repository.HiringRepository
import javax.inject.Inject

/**
 * Implementation of Hiring repository
 * single source of truth connect to
 * Network layer or data base
 * */
class HiringRepositoryImpl @Inject constructor(
    private val hiringService: HiringService
) : HiringRepository {

    override suspend fun getHiringList(): ServiceResult<List<HiringResponse>> {
        return fetchHiringList()
    }

    private suspend fun fetchHiringList(): ServiceResult<List<HiringResponse>> =
        try {
            ServiceResult.Success(hiringService.getHiringList())
        } catch (exception: Exception) {
            ServiceResult.Error(message = exception.message.toString())
        }
}