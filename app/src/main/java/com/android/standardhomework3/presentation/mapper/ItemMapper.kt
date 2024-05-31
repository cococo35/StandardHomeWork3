package com.android.standardhomework3.presentation.mapper

import com.android.standardhomework3.data.entity.MyCardEntity
import com.android.standardhomework3.presentation.model.MyCardModel

fun List<MyCardEntity>.asMyCardModel(): List<MyCardModel> {
    return map {
        MyCardModel(
            it.name,
            it.number,
            it.expiration,
            it.price,
            it.viewType
        )
    }
}