package com.android.standardhomework3.data.database.cache

import com.android.standardhomework3.data.repository.SearchRepositoryImpl
import com.android.standardhomework3.presentation.search.repository.CacheRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface CacheModule {
    @Binds
    fun bindsUserCacheDataSource(userCacheRepositoryImpl: SearchRepositoryImpl) : CacheRepository
}