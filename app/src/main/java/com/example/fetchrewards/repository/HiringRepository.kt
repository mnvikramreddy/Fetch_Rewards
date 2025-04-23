package com.example.fetchrewards.repository

import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.api.ServiceResult

interface HiringRepository {

    //provide the hiring list
    suspend fun getHiringList(): ServiceResult<List<HiringResponse>>
}