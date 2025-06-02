package com.example.fetchrewards.api

/**
 * Used to read the network response
 * */
sealed class ServiceResult<out T> {
    data class Success<out T>(val data: T): ServiceResult<T>()
    data class Error(val message: String): ServiceResult<Nothing>()
}