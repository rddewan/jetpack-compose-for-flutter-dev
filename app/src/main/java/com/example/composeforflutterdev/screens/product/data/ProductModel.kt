package com.example.composeforflutterdev.screens.product.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val id: Int,
    val name: String,
    val description: String
): Parcelable
