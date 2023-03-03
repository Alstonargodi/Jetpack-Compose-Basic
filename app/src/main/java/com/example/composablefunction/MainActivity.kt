package com.example.composablefunction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composer
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablefunction.ui.theme.ComposableFunctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableFunctionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

//personal memoziation
@Composable fun counterApp(){
    Text(text = "memozation")
    Text(text = "memozation")
    Text(text = "memozation")
}

//remember
@Composable fun App(items : List<String>,query : String){
//    val result = remember {
//        items.filter { it.matches(query) }
//    }
}

//storing parameter
@Composable fun Address(
    number : Int,
    street : String,
    city : String,
    country : String,
    zip : String
){
    Text("alamat")
    Text("$number $street")
    Text(city)
    Text(", ")
    Text(country)
    Text(" ")
    Text(zip)
}

@Composable fun Building(number : Int){
    Address(
        number = number,
        street = "jalan",
        city = "kota",
        country = "indonesia",
        zip = "2323"
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableFunctionTheme {
        Greeting("Android")
    }
}