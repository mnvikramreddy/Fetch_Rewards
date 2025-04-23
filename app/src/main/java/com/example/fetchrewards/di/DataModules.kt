package com.example.fetchrewards.di

import com.example.fetchrewards.repository.HiringRepository
import com.example.fetchrewards.repository.impl.HiringRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModules {

    @Binds
    abstract fun bindHiringRepository(repository: HiringRepositoryImpl): HiringRepository

}