package com.android.standardhomework3.data

import android.os.Parcelable
import com.android.standardhomework3.presentation.MultiViewEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyCard(

    val name: String,
    val number: String,
    val expiration: String,
    val price: String,
    val viewType: MultiViewEnum

) : Parcelable
