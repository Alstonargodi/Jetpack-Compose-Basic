package com.example.basic_layout_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basic_layout_compose.components.Greeting
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

                }
            }
        }
    }
}

@Composable
private fun greetingList(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.padding(
            vertical = 4.dp,
        )
    ) {
        for(name in Constant.dataNames){
            Greeting(name = name)
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
        greetingList()
    }
}