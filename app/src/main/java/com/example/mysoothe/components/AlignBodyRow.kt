package com.example.mysoothe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mysoothe.DataDummy
import com.example.mysoothe.R

@Composable
fun AlignBodyRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(DataDummy.alignYourBodyData) { item ->
            AlignBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}