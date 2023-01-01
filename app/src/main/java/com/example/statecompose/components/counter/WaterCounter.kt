package com.example.statecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.statecompose.components.WellTaskItem
import com.example.statecompose.components.counter.CounterItem

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        //mechanisme to store single object
        var count by rememberSaveable {
            mutableStateOf(0)
        }
        if(count > 0){
            var showTask by remember {
                mutableStateOf(true)
            }
            if (showTask){
                CounterItem(
                    task = "reach maximum counter",
                    onClose = { showTask = false },
                    onCheckedChange = {},
                    checked = false
                )
            }
            Text(
                text = "current number $count",
                modifier = modifier.padding(16.dp)
            )
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "increase")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)
            ) {
                Text(text = "clear")
            }
        }
    }
}
