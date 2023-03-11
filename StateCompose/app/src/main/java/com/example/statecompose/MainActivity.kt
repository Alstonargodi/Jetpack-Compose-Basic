package com.example.statecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    SwitchScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(){
    var name = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = name.value,
        onValueChange = { newName ->
          name.value = newName
        },
        label = {
            Text(text = "name")
        },
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun StatefullCounter(
    modifier: Modifier = Modifier,
){
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(
        count = count,
        onClick = { count++},
        modifier = modifier
    )
}

//stateless counter
@Composable
fun StatelessCounter(
    modifier: Modifier = Modifier,
    count : Int,
    onClick : () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ){
        Text(text = "button click $count times")
        Button(onClick = { onClick() }) {
            Text(text = "click me")
        }
    }
}

@Composable
fun SwitchScreen(
    modifier: Modifier = Modifier
){
    var checked by remember {
        mutableStateOf(false)
    }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(16.dp)
    ){
        MySwitch(
            checked = checked ,
            onCheckChanged = { checked = it}
        )
        Text(
            text = if (checked) "ON" else "OFF",
            Modifier.clickable {
                checked = !checked
            }
        )
    }
}
@Composable
fun MySwitch(
    checked : Boolean,
    onCheckChanged: (Boolean) -> Unit,
){
    Switch(
        checked = checked ,
        onCheckedChange = {
            onCheckChanged(it)
        }
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateComposeTheme {
        SwitchScreen()
    }
}