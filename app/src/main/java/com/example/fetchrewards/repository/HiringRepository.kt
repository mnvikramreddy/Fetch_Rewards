package com.example.fetchrewards.repository

import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.ServiceResult
import com.example.fetchrewards.database.entity.HiringItem

interface HiringRepository {

    //provide the hiring list
    suspend fun getHiringList(): ServiceResult<List<HiringItem>>
}