package com.android.standardhomework3.presentation.search.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.standardhomework3.presentation.search.main.GitHubUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubUserActivity : AppCompatActivity() {

    private val gitHubUserViewModel: GitHubUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gitHubUserViewModel.getGitHubUserList()

        gitHubUserViewModel.getGitHubUserList.observe(this@GitHubUserActivity){ gitHubUserList ->
            Log.d("debug", gitHubUserList.toString())
        }
    }
}