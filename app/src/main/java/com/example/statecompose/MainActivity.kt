package com.example.statecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statecompose.ui.theme.StateComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellScreen()
                }
            }
        }
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        //mechanisme to store single object
        var count by remember {
            mutableStateOf(0)
        }
        Text(
            text = "count $count",
            modifier = modifier.padding(16.dp)
        )        
        Button(
            onClick = { count++ },
            Modifier.padding(top = 8.dp)
        ) {
            Text(text = "increase")
        }
    }
}

@Composable
fun WellScreen(modifier: Modifier = Modifier){
    WaterCounter(modifier = modifier)
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    StateComposeTheme {
        WellScreen()
    }
}