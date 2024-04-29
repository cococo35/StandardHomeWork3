package com.android.standardhomework3.data.database

import com.android.standardhomework3.data.entity.MyCardEntity

object DataSource {
    fun getCardList(): List<MyCardEntity> { return  dataList() }
}