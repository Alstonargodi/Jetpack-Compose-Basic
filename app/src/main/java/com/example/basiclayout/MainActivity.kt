package com.example.basiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiclayout.ui.theme.BasicLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutTheme {
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

@Composable fun ContactCard(){
    Row( 
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.yuru) ,
                contentDescription = "avatar",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.yuru) ,
                contentDescription = "status",
                tint = Color.Gray,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "nama", fontWeight = FontWeight.Bold)
            Text(text = "online")
        }
    }
}

//alignment
@Composable fun align(){
    Column(modifier = Modifier.padding(16.dp)){
        Row (
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "top",
                modifier = Modifier.align(
                    Alignment.CenterVertically
                )
            )
            Text(
                text = "1",
                modifier = Modifier.align(
                    Alignment.CenterVertically
                )
            )
            Text(
                text = "2",
                modifier = Modifier.align(
                    Alignment.CenterVertically
                )
            )
        }
    }
}

//weight
@Composable
fun ButtonText(
    text : String,
    modifier: Modifier = Modifier
){
    Button(
        colors = ButtonDefaults.buttonColors(
           colorResource(id =  R.color.teal_200)
        ),
        modifier = modifier.padding(4.dp),
        onClick = { }
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Weight(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            ButtonText(text = "1",Modifier.weight(1f) )
            ButtonText("1", Modifier.weight(1f))
            ButtonText("1", Modifier.weight(1f))
        }
        Row {
            ButtonText("1", Modifier.weight(1f))
            ButtonText("2", Modifier.weight(2f))
            ButtonText("1", Modifier.weight(1f))
        }
        Row {
            ButtonText("1", Modifier.weight(1f))
            ButtonText("2",Modifier.weight(2f,fill = false))
            ButtonText("3", Modifier.weight(3f, fill = true))
        }
        Row {
            ButtonText("1", Modifier.weight(1f))
            ButtonText("2", Modifier.weight(2f))
            ButtonText("3", Modifier.weight(3f))
        }
    }
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
    BasicLayoutTheme {
        Weight()
    }
}