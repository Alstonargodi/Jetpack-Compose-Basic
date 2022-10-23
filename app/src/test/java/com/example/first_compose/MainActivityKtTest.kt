package com.example.first_compose

import junit.framework.Assert.assertEquals
import org.junit.Test

class MainActivityKtTest{

    @Test
    fun calculate_20_percent_tip(){
        val amount = 10.00
        val tip = 20.00
        val expectedResult = "IDR2.00"
        val actualTip = tripCalculator(
            amount,
            tip
        )
        assertEquals(expectedResult,actualTip)
    }
}