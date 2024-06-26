package com.android.standardhomework3.data.remote.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.android.standardhomework3.data.remote.model.GitHubUserResponse

class SearchPagingRemoteDataSource (
    private val query : String,
    private val searchRemoteDataSource : SearchRemoteDataSource
): PagingSource<Int, GitHubUserResponse>() {
    override fun getRefreshKey(state: PagingState<Int, GitHubUserResponse>): Int? {
        return state.anchorPosition?.let {
            val closestPageToPosition = state.closestPageToPosition(it)
            closestPageToPosition?.prevKey?.plus(defaultDisplay)
                ?: closestPageToPosition?.nextKey?.minus(defaultDisplay)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitHubUserResponse> {
        val start = params.key ?: defaultStart

        return try {
            val response = searchRemoteDataSource.getGitHubUser(query, params.loadSize, start)

            val items = response.items
            val nextKey = if (items.isEmpty()) {
                null
            } else {
                start + params.loadSize
            }
            val prevKey = if (start == defaultStart) {
                null
            } else {
                start - defaultDisplay
            }
            LoadResult.Page(items, prevKey, nextKey)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
    companion object {
        const val defaultStart = 1
        const val defaultDisplay = 10
    }
}