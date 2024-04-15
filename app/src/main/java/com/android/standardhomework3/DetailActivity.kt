package com.android.standardhomework3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.standardhomework3.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txDetailName.text = intent.getStringExtra("_name")
        binding.txDetailNumber.text = intent.getStringExtra("_number")
        binding.txDetailExpiration.text = intent.getStringExtra("_expiration")
        binding.txDetailPrice.text = intent.getStringExtra("_price")
    }
}