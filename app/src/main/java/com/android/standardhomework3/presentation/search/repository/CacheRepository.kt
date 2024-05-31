package com.android.standardhomework3.presentation.search.repository

import com.android.standardhomework3.data.database.entity.FavoriteUserEntity

interface CacheRepository {
    suspend fun insertGitHubUserList(favoriteUserEntity: FavoriteUserEntity)
}