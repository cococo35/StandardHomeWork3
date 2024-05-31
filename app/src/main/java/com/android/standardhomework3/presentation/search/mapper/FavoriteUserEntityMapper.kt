package com.android.standardhomework3.presentation.search.mapper

import com.android.standardhomework3.data.database.entity.FavoriteUserEntity
import com.android.standardhomework3.presentation.search.model.GitHubUser

fun GitHubUser.asFavoriteUserEntity(): FavoriteUserEntity {
    return FavoriteUserEntity(
        avatarUrl = avatarUrl,
        loginName = loginName,
        id = id,
        isFavorite = isFavorite
    )
}