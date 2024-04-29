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

// 간단하게 MyCardEntity를 MyCardModel 구조에 맞게 데이터를 mapping 해준다 생각하면 된...되...나?
// 네트워크 데이터나 데이터 베이스에서 받아온 데이터에서 필요한 것만 뽑아서 사용할 수 있도록 하는 구조이...다...