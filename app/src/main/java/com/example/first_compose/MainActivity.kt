package com.example.first_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.first_compose.ui.theme.FirstcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("toniAndroid")
                }
            }
        }
    }
}

@Composable
fun GreetingText(message : String,person : String){
    Column() {
        Text(
            text = "saya adalah text $message",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp)
        )
        Text(
            text = "from $person",
            fontSize = 25.sp,
            modifier = Modifier
                .wrapContentWidth(Alignment.End)
                .padding(start = 20.dp, end = 10.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun GreetingImageWithText(message: String,person: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box() {
        Image(
            painter = image,
            contentDescription = "drawble",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
            ,
            contentScale = ContentScale.Crop
        )
        GreetingText(message = message, person = person)
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    FirstcomposeTheme {
        GreetingImageWithText(message = "row", person = stringResource(R.string.personAname))
    }
}