package com.android.standardhomework3.presentation.search.model

data class GitHubUserList(val items: List<GitHubUser>)
data class GitHubUser(val avatarUrl: String, val loginName: String,  val id: Int, val isFavorite : Boolean = false)