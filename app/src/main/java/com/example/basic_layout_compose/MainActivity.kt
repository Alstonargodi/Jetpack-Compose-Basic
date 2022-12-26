package com.example.basic_layout_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basic_layout_compose.ui.theme.BasiclayoutcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasiclayoutcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
private fun reusable(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp
        ),
        color = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier.padding(24.dp)){
            Column(
                modifier = Modifier.weight(
                    1f
                )
            ) {
                for(name in Constant.dataNames){
                    Greeting(name = name)
                }
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "detail")
            }
        }
    }
}
@Composable
fun Greeting(name: String) {
    Surface(
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp
        ),
        color = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier.weight(
                    1f
                )
            ) {
                Text(text = name)
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "detail")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun DefaultPreview() {
    BasiclayoutcomposeTheme {
        for (name in Constant.dataNames){
            Greeting(name = name)
        }
    }
}