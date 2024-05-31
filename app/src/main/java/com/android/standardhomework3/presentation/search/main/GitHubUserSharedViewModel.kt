package com.android.standardhomework3.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.standardhomework3.presentation.search.model.GitHubUser

class GitHubUserSharedViewModel : ViewModel() {
    private val _favoriteLiveData = MutableLiveData<List<GitHubUser>>()
    val favoriteLiveData: LiveData<List<GitHubUser>> = _favoriteLiveData

    fun setFavoriteList(list: List<GitHubUser>) {
        _favoriteLiveData.value = list
    }
}