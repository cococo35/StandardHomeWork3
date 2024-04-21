package com.android.standardhomework3.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.standardhomework3.data.MyCard
import com.android.standardhomework3.data.dataList
import com.android.standardhomework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val cardViewModel by viewModels<CardViewModel> { CardViewModelFactory() }
    private val adapter: MultiViewTypeAdapter by lazy {
        MultiViewTypeAdapter{ card -> adapterOnClick(card) }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val dataList = dataList()
        val dataList = cardViewModel.cardLiveData
        adapter.dataList = dataList


//        val adapter = MultiViewTypeAdapter(dataList)
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
//        adapter.itemClick = object : MultiViewTypeAdapter.ItemClick {
//            override fun onClick(view: View, position: Int) {
//                val data = MyCard(
//                    dataList[position].name,
//                    dataList[position].number,
//                    dataList[position].expiration,
//                    dataList[position].price
//                )
//                val argument = Bundle()
//                argument.putParcelable("Card_Key", data)
//                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                intent.putExtras(argument)
//                startActivity(intent)
//            }
//        }

    }

    fun adapterOnClick(card: MyCard) {
        val argument = Bundle()
        argument.putParcelable("Card_Key", card)
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtras(argument)
        startActivity(intent)
    }
}