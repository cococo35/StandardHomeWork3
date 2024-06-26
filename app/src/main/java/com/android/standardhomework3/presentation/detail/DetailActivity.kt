package com.android.standardhomework3.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.standardhomework3.data.entity.MyCardEntity
import com.android.standardhomework3.databinding.ActivityDetailBinding
import com.android.standardhomework3.presentation.model.MyCardModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<MyCardModel>("Card_Key")
        binding.txDetailName.text = data?.name
        binding.txDetailNumber.text = data?.number
        binding.txDetailExpiration.text = data?.expiration
        binding.txDetailPrice.text = data?.price

    }
}