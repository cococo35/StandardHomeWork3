package com.android.standardhomework3.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.android.standardhomework3.databinding.FragmentGithubFavoriteUsersBinding
import com.android.standardhomework3.presentation.search.main.GitHubUserSharedViewModel

class FavoriteListFragment : Fragment() {
    companion object {
        fun newInstance() = FavoriteListFragment()
    }

    private var _binding : FragmentGithubFavoriteUsersBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel : GitHubUserSharedViewModel by activityViewModels()
    private val favoriteListAdapter : FavoriteListAdapter by lazy { FavoriteListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGithubFavoriteUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        sharedViewModel.favoriteLiveData.observe(viewLifecycleOwner) {
            favoriteListAdapter.gitHubUserList = it
            binding.rvGithubUsers.adapter = favoriteListAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}