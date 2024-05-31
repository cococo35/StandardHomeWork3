package com.android.standardhomework3.data.remote.di

import com.android.standardhomework3.data.repository.SearchRepositoryImpl
import com.android.standardhomework3.presentation.search.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface SearchModule {
    @Binds
    fun bindsSearchRepository(searchRepositoryImpl: SearchRepositoryImpl) : SearchRepository
}