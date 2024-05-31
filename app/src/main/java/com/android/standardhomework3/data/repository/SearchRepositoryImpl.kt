package com.android.standardhomework3.data.repository

import com.android.standardhomework3.data.database.DataSource
import com.android.standardhomework3.data.remote.remote.SearchRemoteDataSource
import com.android.standardhomework3.presentation.mapper.asMyCardModel
import com.android.standardhomework3.presentation.search.repository.SearchRepository
import com.android.standardhomework3.presentation.search.mapper.toEntity

class SearchRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: SearchRemoteDataSource
) : SearchRepository {
    override fun getCardList() = dataSource.getCardList().asMyCardModel()

    override suspend fun getGitHubUserList(userName: String) =
        remoteDataSource.getGitHubUser(userName).toEntity()
}