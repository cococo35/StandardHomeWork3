package com.android.standardhomework3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.standardhomework3.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = init()

        val adapter = MultiViewTypeAdapter(dataList)
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MultiViewTypeAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("_name", dataList[position].name)
                intent.putExtra("_number", dataList[position].number)
                intent.putExtra("_expiration", dataList[position].expiration)
                intent.putExtra("_price", dataList[position].price)
                startActivity(intent)
            }
        }
    }

    private fun init(): MutableList<CardData> {
        val dataList = mutableListOf<CardData>()
        val decimal = DecimalFormat("$#,###.00")
        dataList.add(MyCard1("Anderson", "2423 3581 9503 2412", "21 / 24", decimal.format(3100.30)))
        dataList.add(MyCard2("Anderson", "2423 3581 9503 2412", "21 / 24", decimal.format(3100.30)))
        dataList.add(MyCard3("Anderson", "2423 3581 9503 2412", "21 / 24", decimal.format(3100.30)))
        return dataList
    }
}