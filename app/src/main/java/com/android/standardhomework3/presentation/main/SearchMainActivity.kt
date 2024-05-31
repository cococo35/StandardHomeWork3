package com.android.standardhomework3.presentation.main

import androidx.appcompat.app.AppCompatActivity
import com.android.standardhomework3.databinding.SearchMainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMainActivity : AppCompatActivity() {
    private val binding : SearchMainActivityBinding by lazy {
        SearchMainActivityBinding.inflate(layoutInflater)
    }
    private val viewPagerAdapter by lazy {
        SearchMainViewPagerAdapter(this)
    }
}