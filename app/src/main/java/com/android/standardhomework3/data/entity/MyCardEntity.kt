package com.android.standardhomework3.data.entity

import com.android.standardhomework3.presentation.main.MultiViewEnum

data class MyCardEntity(

    val name: String,
    val number: String,
    val expiration: String,
    val price: String,
    val viewType: MultiViewEnum
)
