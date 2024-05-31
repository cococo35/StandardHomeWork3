package com.android.standardhomework3.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.standardhomework3.R
import com.android.standardhomework3.databinding.ItemGithubUserBinding
import com.android.standardhomework3.presentation.search.model.GitHubUser

class FavoriteListAdapter : RecyclerView.Adapter<FavoriteListAdapter.FavoriteUserViewHolder>() {
    var gitHubUserList = listOf<GitHubUser>()

    class FavoriteUserViewHolder(private val binding: ItemGithubUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(gitHubUser: GitHubUser) {
                with(binding) {
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_github_user, parent, false)
        return FavoriteUserViewHolder(ItemGithubUserBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
    }

    override fun onBindViewHolder(holder: FavoriteUserViewHolder, position: Int) {
        holder.bind(gitHubUserList[position])
    }

}