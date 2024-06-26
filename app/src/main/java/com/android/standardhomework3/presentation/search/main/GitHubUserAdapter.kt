package com.android.standardhomework3.presentation.search.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.standardhomework3.R
import com.android.standardhomework3.databinding.ItemGithubUserBinding
import com.android.standardhomework3.presentation.search.model.GitHubUser

class GitHubUserAdapter(
    private val onClick: (GitHubUser) -> Unit
) :
    RecyclerView.Adapter<GitHubUserAdapter.GitHubUserViewHolder>() {
    var gitHubUserList = listOf<GitHubUser>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_github_user, parent, false)
        return GitHubUserViewHolder(ItemGithubUserBinding.bind(view), onClick)
    }

    override fun getItemCount(): Int {
        return gitHubUserList.size
    }

    override fun onBindViewHolder(holder: GitHubUserViewHolder, position: Int) {
        val currentItem = gitHubUserList[position]
        holder.bind(currentItem)

        holder.itemView.setOnClickListener {
            onClick(currentItem)
        }
    }

    class GitHubUserViewHolder(
        private val binding: ItemGithubUserBinding,
        private val onClick: (GitHubUser) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gitHubUser: GitHubUser) = with(binding) {
            switchFavorite.isChecked = gitHubUser.isFavorite
            tvUserName.text = gitHubUser.loginName
            imgUserAvatar.load(gitHubUser.avatarUrl)
            switchFavorite.setOnClickListener {
                if (gitHubUser.isFavorite != switchFavorite.isChecked) {
                    onClick(gitHubUser)
                }
            }
        }
    }
}