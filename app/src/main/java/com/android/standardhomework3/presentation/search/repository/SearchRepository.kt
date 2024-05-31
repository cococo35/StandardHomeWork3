package com.android.standardhomework3.presentation.search.repository

import com.android.standardhomework3.presentation.model.MyCardModel

interface SearchRepository {
    fun getCardList() : List<MyCardModel>
    suspend fun getGitHubUserList(userName : String) : GitHubUserListEntity
}