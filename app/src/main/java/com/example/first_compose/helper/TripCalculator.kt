package com.example.first_compose.helper

import java.text.NumberFormat

fun TripCalculator(amount : Double, tippercent : Double = 15.0): String {
    val tip = tippercent / 100 * amount
    return NumberFormat
        .getCurrencyInstance()
        .format(tip)
}