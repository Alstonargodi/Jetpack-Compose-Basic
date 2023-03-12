package com.example.statecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
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
                    Column {
                        StatefullConverter()
                        Statelessconverter()
                        TwoWayConverterApp()
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatefullConverter(
    modifier: Modifier = Modifier
){
    //statefull
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    Column(
        modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.stateful_converter),
            style = MaterialTheme.typography.titleMedium
        )
        OutlinedTextField(
            value = input,
            label = {
                    Text(
                        text = stringResource(
                            id = R.string.enter_celsius
                        )
                    )
            },
            onValueChange = { inputValue ->
                input = inputValue
                output = convertToFarenheit(inputValue)
            } )
        Text(
            text = stringResource(
                id = R.string.temperature_fahrenheit,output
            ),
        )
    }
}

@Composable
fun Statelessconverter(
    modifier: Modifier = Modifier
){
    //statefull
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    Column(
        modifier.padding(16.dp)
    ) {
        //stateless
        Statelesstemperature(
            input = input,
            output = output ,
            onValueChange = { inputValue ->
                input = inputValue
                output = convertToFarenheit(inputValue)
            }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Statelesstemperature(
    input : String,
    output : String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.stateless_converter),
            style = MaterialTheme.typography.labelMedium
        )
        OutlinedTextField(
            value = input,
            onValueChange = onValueChange,
            label = {
                Text(text = stringResource(id = R.string.enter_celsius))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
        )
        Text(
            stringResource(id = R.string.temperature_fahrenheit,output)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    StateComposeTheme {
        Statelessconverter()
    }
}