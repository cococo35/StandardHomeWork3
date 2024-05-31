package com.android.standardhomework3.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.standardhomework3.databinding.ActivityMainBinding
import com.android.standardhomework3.presentation.detail.DetailActivity
import com.android.standardhomework3.presentation.model.MyCardModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataList : List<MyCardModel>
    private val cardViewModel by viewModels<MainViewModel> { MainViewModelFactory() }
    private val multiViewAdapter: MultiViewTypeAdapter by lazy {
        MultiViewTypeAdapter{ card -> adapterOnClick(card) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val dataList = cardViewModel.cardLiveData

        initViewModel()
        initData()

//        binding.mainRecyclerview.adapter = adapter
//        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)

    }

    private fun adapterOnClick(card: MyCardModel) {
        val argument = Bundle()
        argument.putParcelable("Card_Key", card)
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtras(argument)
        startActivity(intent)
    }

    private fun initData() {
        cardViewModel.getMyCardModel()
    }

    private fun initView() {
        multiViewAdapter.dataList = dataList

        with(binding.mainRecyclerview) {
            adapter = multiViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initViewModel() {
        cardViewModel.getMyCardModel.observe(this@MainActivity) {
            dataList = it
            initView()
        }
    }
}