package com.android.standardhomework3.data.database

import com.android.standardhomework3.data.entity.MyCardEntity
import com.android.standardhomework3.presentation.main.MultiViewEnum

fun dataList() : MutableList<MyCardEntity> {
    val decimal = java.text.DecimalFormat("$#,###.00") //extension으로 처리
    return mutableListOf(
        MyCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD1
        ),
        MyCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD2
        ),
        MyCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD3
        ),
        MyCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD3
        ),
        MyCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD3
        ),
        MyCardEntity(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD3
        ),
    )
}