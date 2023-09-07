package com.hnf.tugasakhir2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Buah(
    val name: String,
    val descripton: String,
    val photo: Int
) :Parcelable
