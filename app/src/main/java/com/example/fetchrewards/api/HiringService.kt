package com.example.fetchrewards.api

import retrofit2.http.GET

interface HiringService {

    @GET("hiring.json")
    suspend fun getHiringList(): List<HiringResponse>
}
