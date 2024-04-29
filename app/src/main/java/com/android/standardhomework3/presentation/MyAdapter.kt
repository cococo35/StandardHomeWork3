package com.android.standardhomework3.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.standardhomework3.data.MyCard
import com.android.standardhomework3.data.dataList
import com.android.standardhomework3.databinding.Card1RecyclerviewBinding
import com.android.standardhomework3.databinding.Card2RecyclerviewBinding
import com.android.standardhomework3.databinding.Card3RecyclerviewBinding
import com.android.standardhomework3.databinding.UnknownRecyclerviewBinding

class MultiViewTypeAdapter(private val onClick: (MyCard) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList = dataList()

    override fun getItemViewType(position: Int): Int {
        return dataList[position].viewType.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val multiViewType = MultiViewEnum.entries.find { it.viewType == viewType}
        return when(multiViewType) {
            MultiViewEnum.CARD1 -> {
                val binding = Card1RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card1Holder(binding)
            }
            MultiViewEnum.CARD2 -> {
                val binding = Card2RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card2Holder(binding)
            }
            MultiViewEnum.CARD3 -> {
                val binding = Card3RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                Card3Holder(binding)
            }
           else -> {
                val binding = UnknownRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                UnknownHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentItem = dataList[position]
        when(holder) {
            is Card1Holder -> {
                holder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            is Card2Holder -> {
                holder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
            is Card3Holder -> {
                holder.bind(currentItem)

                holder.itemView.setOnClickListener {
                    onClick(currentItem)
                }
            }
        }
    }


    class Card1Holder(private val binding: Card1RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: MyCard) {
            binding.apply {
                txCardName.text = card.name
                txCardNumber.text = card.number
                txCardExpiration.text = card.expiration
                txCardPrice.text = card.price
            }
        }
    }
    class Card2Holder(private val binding: Card2RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: MyCard) {
            binding.apply {
                txCardName.text = card.name
                txCardNumber.text = card.number
                txCardExpiration.text = card.expiration
                txCardPrice.text = card.price
            }
        }
    }
    class Card3Holder(private val binding: Card3RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: MyCard) {
            binding.apply {
                txCardName.text = card.name
                txCardNumber.text = card.number
                txCardExpiration.text = card.expiration
                txCardPrice.text = card.price
            }
        }
    }

    class UnknownHolder(binding: UnknownRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = Unit
    }
}