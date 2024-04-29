package com.android.standardhomework3.data.repository

import com.android.standardhomework3.data.database.DataSource
import com.android.standardhomework3.presentation.mapper.asMyCardModel
import com.android.standardhomework3.presentation.model.MyCardModel
import com.android.standardhomework3.presentation.repository.SearchRepository

class SearchRepositoryImpl(private val dataSource: DataSource): SearchRepository {
    override fun getCardList() = dataSource.getCardList().asMyCardModel()
}