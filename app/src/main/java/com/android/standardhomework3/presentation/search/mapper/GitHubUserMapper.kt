package com.android.standardhomework3.presentation.search.mapper

import com.android.standardhomework3.data.remote.model.GitHubUserListResponse
import com.android.standardhomework3.data.remote.model.GitHubUserResponse
import com.android.standardhomework3.presentation.search.model.GitHubUser
import com.android.standardhomework3.presentation.search.model.GitHubUserList

fun GitHubUserListResponse.toEntity() = GitHubUserList(
    items = items.asGitHubUserEntity()
)

fun List<GitHubUserResponse>.asGitHubUserEntity(): List<GitHubUser> {
    return map {
        GitHubUser(
            it.avatarUrl,
            it.loginName
        )
    }
}