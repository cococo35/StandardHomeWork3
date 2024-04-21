package com.android.standardhomework3.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.standardhomework3.data.MyCard
import com.android.standardhomework3.data.dataList
import com.android.standardhomework3.databinding.Card1RecyclerviewBinding
import com.android.standardhomework3.databinding.Card2RecyclerviewBinding
import com.android.standardhomework3.databinding.Card3RecyclerviewBinding

class MultiViewTypeAdapter(private val onClick: (MyCard) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val CARD1 = 0
        private const val CARD2 = 1
        private const val CARD3 = 2
    }

    var dataList = dataList()
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> CARD1
            1 -> CARD2
            2 -> CARD3
            else -> throw IllegalArgumentException("nothing")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CARD1 -> {
                var binding = Card1RecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return Card1Holder(binding)
            }

            CARD2 -> {
                var binding = Card2RecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return Card2Holder(binding)
            }

            CARD3 -> {
                var binding = Card3RecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return Card3Holder(binding)
            }

            else -> throw IllegalArgumentException("nothing")
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        when(holder) {
            is Card1Holder -> {
                holder.name.text = dataList[position].name
                holder.number.text = dataList[position].number
                holder.expiration.text = dataList[position].expiration
                holder.price.text = dataList[position].price
                holder.itemView.setOnClickListener {
                    onClick(dataList[position])
                }
            }
            is Card2Holder -> {
                holder.name.text = dataList[position].name
                holder.number.text = dataList[position].number
                holder.expiration.text = dataList[position].expiration
                holder.price.text = dataList[position].price
                holder.itemView.setOnClickListener {
                    onClick(dataList[position])
                }
            }
            is Card3Holder -> {
                holder.name.text = dataList[position].name
                holder.number.text = dataList[position].number
                holder.expiration.text = dataList[position].expiration
                holder.price.text = dataList[position].price
                holder.itemView.setOnClickListener {
                    onClick(dataList[position])
                }
            }
        }
    }


    class Card1Holder(private val binding: Card1RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.txCardName
        val number = binding.txCardNumber
        val expiration = binding.txCardExpiration
        val price = binding.txCardPrice
    }
    class Card2Holder(val binding: Card2RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.txCardName
        val number = binding.txCardNumber
        val expiration = binding.txCardExpiration
        val price = binding.txCardPrice
    }
    class Card3Holder(val binding: Card3RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.txCardName
        val number = binding.txCardNumber
        val expiration = binding.txCardExpiration
        val price = binding.txCardPrice
    }
}