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

        val dataList = dataList()

        val adapter = MultiViewTypeAdapter(dataList)
        binding.mainRecyclerview.adapter = adapter
        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter.itemClick = object : MultiViewTypeAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val data = MyCard(
                    dataList[position].name,
                    dataList[position].number,
                    dataList[position].expiration,
                    dataList[position].price
                )
                val argument = Bundle()
                argument.putParcelable("Card_Key", data)
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtras(argument)
                startActivity(intent)
            }
        }

    }
}