package com.android.standardhomework3.data.repository

import com.android.standardhomework3.data.database.FavoriteDao
import com.android.standardhomework3.data.database.entity.FavoriteUserEntity
import javax.inject.Inject

class UserCacheRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : CacheRepository {
    override suspend fun insertGitHubUserList(favoriteUserEntity: FavoriteUserEntity) {
        return favoriteDao.insertFavoriteUser(favoriteUserEntity)
    }
}