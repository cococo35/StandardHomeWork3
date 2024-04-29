package com.android.standardhomework3.presentation.repository

import com.android.standardhomework3.presentation.model.MyCardModel

interface SearchRepository {
    fun getCardList() : List<MyCardModel>
}