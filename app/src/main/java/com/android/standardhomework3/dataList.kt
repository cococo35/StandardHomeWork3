package com.android.standardhomework3

import android.icu.text.DecimalFormat

fun dataList() : MutableList<MyCard> {
    val decimal = java.text.DecimalFormat("$#,###.00")
    return mutableListOf(
        MyCard(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30)
        ),
        MyCard(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30)
        ),
        MyCard(
            "Anderson",
            "2423 3581 9503 2412",
            "21 / 24",
            decimal.format(3100.30)
        )
    )
}