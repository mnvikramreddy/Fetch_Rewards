package com.example.fetchrewards.api

import com.google.gson.annotations.SerializedName

data class HiringResponse(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("listId") val listId: Int,
    @field:SerializedName("name") val name: String
)
