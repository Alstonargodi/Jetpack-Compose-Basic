package com.example.basic_layout_compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
                    Myapp(
                        modifer = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun Myapp(modifer: Modifier = Modifier){
    var showOnBoarding by remember {
        mutableStateOf(true)
    }
    Surface(modifer) {
        if (showOnBoarding){ ///change when fillfull condition
            OnBoardingScreen(
                onContinueClick = { showOnBoarding = false }
            )
        }else{
            greetingList()
        }
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "onboarding screen")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClick
        ) {
            Text(text = "continue")
        }
    }
}
@Composable
private fun greetingList(
    modifier: Modifier = Modifier,
    names : List<String> = List(10) { "$it"}
){
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)){
        items(items = names){ name ->
            Greeting(name = name)
        }
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun MyAppPreview() {
    BasiclayoutcomposeTheme() {
        Myapp(Modifier.fillMaxSize())
    }
}