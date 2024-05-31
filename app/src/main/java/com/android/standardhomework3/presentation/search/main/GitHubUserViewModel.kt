package com.android.standardhomework3.presentation.search.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.standardhomework3.presentation.search.repository.CacheRepository
import com.android.standardhomework3.presentation.search.model.GitHubUser
import com.android.standardhomework3.presentation.search.repository.SearchRepository
import com.android.standardhomework3.presentation.search.mapper.asFavoriteUserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubUserViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    private val cacheRepository: CacheRepository
) : ViewModel() {

    private val _getGitHubUserList: MutableLiveData<List<GitHubUser>> = MutableLiveData()
    val getGitHubUserList: LiveData<List<GitHubUser>> get() = _getGitHubUserList

    private val _favoriteUserList: MutableLiveData<List<GitHubUser>> = MutableLiveData()
    val favoriteUserList: LiveData<List<GitHubUser>> get() = _favoriteUserList

    fun getGitHubUserList() {
        viewModelScope.launch {
            _getGitHubUserList.value = searchRepository.getGitHubUserList("cococo35").items
        }
    }

    fun insertGitHubUser(gitHubUser: GitHubUser) {
        viewModelScope.launch {
            cacheRepository.insertGitHubUserList(gitHubUser.asFavoriteUserEntity())
        }
    }

    fun setFavoriteItem(item: GitHubUser) {
        val gitHubUserList = _getGitHubUserList.value!!.toMutableList()

        val position = gitHubUserList.indexOfFirst {
            it.id == item.id
        }
        _getGitHubUserList.value =
            gitHubUserList.also {
                it[position] = item.copy(
                    isFavorite = !item.isFavorite
                )
            }

        _favoriteUserList.value = gitHubUserList.filter {
            it.isFavorite
        }
    }
}