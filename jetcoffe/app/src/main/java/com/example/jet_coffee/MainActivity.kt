package com.example.jet_coffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jet_coffee.ui.components.SearchBar
import com.example.jet_coffee.ui.theme.JetcoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetcoffeeTheme {
                // A surface container using the 'background' color from the theme
                JetCoffeApp()
            }
        }
    }
}

@Composable
fun JetCoffeApp(){
    Column {
        Banner()
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
){
    Box (
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Preview(
    showBackground = false,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    JetcoffeeTheme {
        JetCoffeApp()
    }
}