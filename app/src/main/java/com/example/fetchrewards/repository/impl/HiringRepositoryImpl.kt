package com.example.fetchrewards.repository.impl

import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.HiringService
import com.example.fetchrewards.api.ServiceResult
import com.example.fetchrewards.database.AppDatabase
import com.example.fetchrewards.database.entity.HiringItem
import com.example.fetchrewards.repository.HiringRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Implementation of Hiring repository
 * single source of truth connect to
 * Network layer or data base
 * */
class HiringRepositoryImpl @Inject constructor(
    private val hiringService: HiringService,
    private val appDatabase: AppDatabase
) : HiringRepository {

    override suspend fun getHiringList(): ServiceResult<List<HiringItem>> {
        val dbList = appDatabase.hiringDao().getHiringList()
        return if (dbList.isEmpty()) {
            fetchHiringList()
        } else {
            ServiceResult.Success(dbList)
        }
    }


    private suspend fun fetchHiringList(): ServiceResult<List<HiringItem>> =
        try {
            val response = ServiceResult.Success(hiringService.getHiringList())
            val entities = response.data.filter { !it.name.isNullOrBlank() }.map { it.toEntity() }
            appDatabase.hiringDao().insertHiringList(entities)
            ServiceResult.Success(entities)
        } catch (exception: Exception) {
            ServiceResult.Error(message = exception.message.toString())
        }


    fun HiringResponse.toEntity(): HiringItem {
        return HiringItem(
            id = id,
            listId = listId,
            name = name
        )
    }
}