package com.android.standardhomework3.presentation.model

import android.os.Parcelable
import com.android.standardhomework3.presentation.main.MultiViewEnum
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyCardModel(

    val name: String,
    val number: String,
    val expiration: String,
    val price: String,
    val viewType: MultiViewEnum

) : Parcelable
