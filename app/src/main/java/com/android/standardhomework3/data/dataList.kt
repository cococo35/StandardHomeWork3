package com.android.standardhomework3.data

import com.android.standardhomework3.presentation.MultiViewEnum

fun dataList() : MutableList<MyCard> {
    val decimal = java.text.DecimalFormat("$#,###.00")
    return mutableListOf(
        MyCard(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD1
        ),
        MyCard(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD2
        ),
        MyCard(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30),
            MultiViewEnum.CARD3
        )
    )
}