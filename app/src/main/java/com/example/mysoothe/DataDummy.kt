package com.example.mysoothe

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

object DataDummy {
    @SuppressLint("SupportAnnotationUsage")
    data class DrawableStringPair(
        @DrawableRes val drawable: Int,
        @StringRes val text: String
    )

    val alignYourBodyData = listOf(
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
    ).map { DrawableStringPair(it.first, it.second) }

    val favoriteCollectionsData = listOf(
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
        R.drawable.bocchi to "a",
    ).map { DrawableStringPair(it.first, it.second) }
}