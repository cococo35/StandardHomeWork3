package com.android.standardhomework3.presentation.main

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.standardhomework3.presentation.favorite.FavoriteListFragment
import com.android.standardhomework3.presentation.search.main.GitHubUserFragment

class SearchMainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        SearchMainTabModel(GitHubUserFragment.newInstance(), "Search"),     // ???
        SearchMainTabModel(FavoriteListFragment.newInstance(), "Favorite"),
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int) = fragments[position].fragment

    fun getTitle(position: Int) : Int = fragments[position].title
}