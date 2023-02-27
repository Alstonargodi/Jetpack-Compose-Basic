package com.example.dasarcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dasarcompose.model.SampleName
import com.example.dasarcompose.ui.theme.DasarComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DasarComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  HelloJetpackComposeApp()
                }
            }
        }
    }
}

@Composable
fun HelloJetpackComposeApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        GreetingList(names = SampleName().sampleName)
    }
}

@Composable
fun GreetingList(names : List<String>){
    if (names.isNotEmpty()){
//        Column() {
//            for(name in names){
//                Greeting(name = name)
//            }
//        }
        //lazy coloumn scroll
        LazyColumn{
            items(names){ name->
                Greeting(name = name)
            }
        }
    }else{
        Text(text = "no data")
    }
}

@Composable
fun Greeting(name: String) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose),
                contentDescription = "logo compose",
                modifier = Modifier.size(animatedSizeDp)
            )
            Spacer(
                modifier = Modifier.width(5.dp)
            )
            Column( modifier = Modifier.weight(1f)){
                Text(
                    text = "Hello $name!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "welcome")
            }
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore ,
                    contentDescription =  if (isExpanded) "show less" else "show more"
                )
            }
        }
    }

}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    DasarComposeTheme {
       HelloJetpackComposeApp()
    }
}