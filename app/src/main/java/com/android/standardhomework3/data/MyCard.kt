package com.android.standardhomework3.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyCard(

    val name: String,
    val number: String,
    val expiration: String,
    val price: String

) : Parcelable
