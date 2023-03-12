package com.example.statecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun TwoWayConverterApp(
    modifier: Modifier = Modifier
){
    var celcius by remember {
        mutableStateOf("")
    }
    var fahrenheit by remember {
        mutableStateOf("")
    }

    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.two_way_converter),
            style = MaterialTheme.typography.labelMedium
        )
        GeneralTemperatureInput(
            scale = Scale.CELSIUS,
            input = celcius,
            onValueChange = { inputValue ->
                celcius = inputValue
                fahrenheit = convertToFarenheit(inputValue)
            }
        )
        GeneralTemperatureInput(
            scale = Scale.FAHRENHEIT,
            input = fahrenheit,
            onValueChange = { inputValue ->
                fahrenheit = inputValue
                celcius = convertToCelsius(inputValue)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralTemperatureInput(
    scale: Scale,
    input : String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        OutlinedTextField(
            value = input,
            label = { Text(stringResource(R.string.enter_temperature, scale.scaleName)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange,
        )
    }
}