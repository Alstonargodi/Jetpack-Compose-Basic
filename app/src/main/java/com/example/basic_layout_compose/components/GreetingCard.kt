package com.example.basic_layout_compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String) {
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded.value)
        48.dp
    else
        0.dp

    Surface(
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp
        ),
        color = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = name)
                Text(text = "test $name")
            }
            Button(onClick = {
                expanded.value = !expanded.value
            }) {
                Text(text = if(expanded.value)
                        "show less"
                    else
                        "show more"
                )
            }
        }
    }
}